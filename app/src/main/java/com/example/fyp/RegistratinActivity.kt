package com.example.fyp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import com.google.android.material.textfield.TextInputLayout
import java.lang.ref.WeakReference


class RegistratinActivity : AppCompatActivity() {
    private val radioUserGroup: RadioGroup? = null
    private lateinit var radioUserButton: RadioButton
    private lateinit var login: Button;
    lateinit var appDatabase: AppDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registratin)

        try {
            appDatabase = AppDatabase.getInstance(this@RegistratinActivity)!!
            val username = findViewById<TextInputLayout>(R.id.username)
            val password = findViewById<TextInputLayout>(R.id.password)
            val Mobile = findViewById<TextInputLayout>(R.id.tvMobile)
            val tvCity = findViewById<TextInputLayout>(R.id.tvCity)
            val et_confirmPassword = findViewById<TextInputLayout>(R.id.retryPassword)

            login = findViewById(R.id.loginRegister)
            val loading = findViewById<ProgressBar>(R.id.loading)
            val radioUserGroup = findViewById<RadioGroup>(R.id.radioGroup)
            login.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {

                    try {
                        val temppassword = password.editText?.text.toString().trim()
                        val tempname = username.editText?.text.toString().trim()
                        val tempMobile = Mobile.editText?.text.toString().trim()
                        val temptvCity = tvCity.editText?.text.toString().trim()

                        if (tempname.isEmpty()) {
                            username.editText?.error = "Required"
                            return
                        }
                        if (android.util.Patterns.EMAIL_ADDRESS.matcher(
                                username.editText?.text.toString().trim()
                            ).matches().not()
                        ) {
                            username.editText?.error = "Invalid Email"
                            return
                        }
                        if (temppassword.isEmpty()) {
                            password.editText?.error = "Required"
                            return
                        }
                        if (et_confirmPassword.editText?.text.toString().trim().isEmpty()!!) {
                            et_confirmPassword.editText?.error = "Required"
                            return
                        }
                        if (et_confirmPassword.editText?.text?.toString()
                                .equals(password.editText?.text.toString()).not()
                        ) {
                            et_confirmPassword.editText?.error = "Password did not match"
                            return
                        }
                        if (tempMobile.isEmpty()) {
                            Mobile.editText?.error = "Required"
                            return
                        }
                        if (temptvCity.isEmpty()) {
                            tvCity.editText?.error = "Required"
                            return
                        }

                        val selectedId: Int = radioUserGroup.getCheckedRadioButtonId()
                        radioUserButton = findViewById<View>(selectedId) as RadioButton
                        when (radioUserButton.id) {
                            R.id.radioUser -> {
                                val entity = UserEntity(
                                    0,
                                    tempname,
                                    temppassword,
                                    tempMobile,
                                    temptvCity,
                                    UserType.valueOf("User").toString()
                                );
                                InsertTask(this@RegistratinActivity, entity).execute()
                            }
                            R.id.radioMechanic -> {
                                val entity = UserEntity(
                                    0,
                                    tempname,
                                    temppassword,
                                    tempMobile,
                                    temptvCity,
                                    UserType.valueOf("Mechanic").toString()

                                );
                                InsertTask(this@RegistratinActivity, entity).execute()
                            }
                            R.id.radioAdmin -> {
                                val entity = UserEntity(
                                    0,
                                    tempname,
                                    temppassword,
                                    tempMobile,
                                    temptvCity,
                                    UserType.valueOf("Admin").toString()
                                );
                                InsertTask(this@RegistratinActivity, entity).execute()
                            }
                        }

                    } catch (e: Exception) {
                        Log.e("App ", e.message.toString())
                    }
                }

            })
        } catch (e: Exception) {
            Log.e("App", e.message.toString())
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class InsertTask internal constructor(context: RegistratinActivity?, note: UserEntity) :
        AsyncTask<Void?, Void?, Boolean>() {
        private val activityReference: WeakReference<RegistratinActivity>
        private lateinit var note: UserEntity


        // onPostExecute runs on main thread
        override fun onPostExecute(bool: Boolean) {
            if (bool) {

                when (radioUserButton.id) {
                    R.id.radioUser -> {
                        val intent = Intent(activityReference.get(), UserActivity::class.java)
                        activityReference.get()?.startActivity(intent)
                    }
                    R.id.radioMechanic -> {
                        val intent = Intent(activityReference.get(), MechanicActivity::class.java)
                        activityReference.get()?.startActivity(intent)
                    }
                    R.id.radioAdmin -> {
                        val intent = Intent(activityReference.get(), AdminActivity::class.java)
                        activityReference.get()?.startActivity(intent)
                    }
                }
            }
        }

        init {
            activityReference = WeakReference(context)
            this.note = note
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            var isInserted: Boolean;
            try {
                activityReference.get()?.appDatabase?.userDao()?.insertAll(note);
                isInserted = true;

            } catch (e: Exception) {
                isInserted = false;

            }
            return isInserted;
        }

    }
}

