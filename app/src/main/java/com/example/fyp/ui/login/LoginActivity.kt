package com.example.fyp.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.*
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.lang.ref.WeakReference


class LoginActivity : AppCompatActivity() {
    private val radioUserGroup: RadioGroup? = null
    private lateinit var radioUserButton: RadioButton
    lateinit var appDatabase: AppDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        appDatabase = AppDatabase.getInstance(this@LoginActivity)!!

        val username = findViewById<TextInputLayout>(R.id.username)
        val password = findViewById<TextInputLayout>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)
        val radioUserGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val tvSignUp = findViewById<TextView>(R.id.tvSignUp)
        tvSignUp.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@LoginActivity, RegistratinActivity::class.java)
                startActivity(intent)
                finish()
            }


        })
        login.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                try {
                    val temppassword = password.editText?.text.toString()
                    val tempname = username.editText?.text.toString()
                    val selectedId: Int = radioUserGroup.getCheckedRadioButtonId()
                    radioUserButton = findViewById<View>(selectedId) as RadioButton
                    if (tempname.isEmpty()) {
                        username.editText?.error = "Required"
                        return
                    }
                    if (temppassword.isEmpty()) {
                        password.editText?.error = "Required"
                        return
                    }
                    when (radioUserButton.id) {
                        R.id.radioUser -> {
                            LoginTask(this@LoginActivity, tempname).execute()
                        }
                        R.id.radioMechanic -> {
                            LoginTask(this@LoginActivity, tempname).execute()
                        }
                        R.id.radioAdmin -> {
                            LoginTask(this@LoginActivity, tempname).execute()
                        }
                    }
                } catch (e: Exception) {
                    Log.e("App", "Error " + e.message.toString())
                }
            }

        })
    }

    @SuppressLint("StaticFieldLeak")
    inner class LoginTask internal constructor(context: LoginActivity?, email: String) :
        AsyncTask<Void?, Void?, String>() {
        private val activityReference: WeakReference<LoginActivity>

        // private lateinit var note: UserEntity
        private lateinit var email: String


        // onPostExecute runs on main thread
        override fun onPostExecute(bool: String) {
            when (bool) {
                UserType.Admin.name -> {
                    val intent = Intent(activityReference.get(), AdminActivity::class.java)
                    activityReference.get()?.startActivity(intent)
                    finish()
                }
                UserType.User.name -> {
                    val intent = Intent(activityReference.get(), UserActivity::class.java)
                    activityReference.get()?.startActivity(intent)
                    finish()
                }
                UserType.Mechanic.name -> {
                    val intent = Intent(activityReference.get(), MechanicActivity::class.java)
                    activityReference.get()?.startActivity(intent)
                    finish()
                }
                UserType.NoUser.name->{
                    Toast.makeText(this@LoginActivity,"No User Found ",Toast.LENGTH_SHORT).show()
                }
            }

        }

        init {
            activityReference = WeakReference(context)
            // this.note =note
            this.email = email
        }

        override fun doInBackground(vararg params: Void?): String {
            var isUserExist: String = ""
            try {
                val entity: UserEntity? =
                    activityReference.get()?.appDatabase?.userDao()?.findByEmail(email)
                if (!entity?.email.isNullOrEmpty()) {
                    isUserExist = entity?.userType!!
                }else{
                    isUserExist= UserType.NoUser.name
                }

            } catch (e: Exception) {


            }
            return isUserExist;
        }

    }
}


