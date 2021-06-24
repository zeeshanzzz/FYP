package com.example.fyp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.lang.ref.WeakReference


class RegistratinActivity : AppCompatActivity() {
    private val radioUserGroup: RadioGroup? = null
    private lateinit var radioUserButton: RadioButton
    private lateinit var login:Button;
     lateinit var appDatabase: AppDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registratin)
        appDatabase= AppDatabase.getInstance(this@RegistratinActivity)!!
        val username = findViewById<TextInputLayout>(R.id.username)
        val password = findViewById<TextInputLayout>(R.id.password)
        val Mobile = findViewById<TextInputLayout>(R.id.tvMobile)
        val tvCity = findViewById<TextInputLayout>(R.id.tvCity)



         login = findViewById(R.id.loginRegister)
        val loading = findViewById<ProgressBar>(R.id.loading)
        val radioUserGroup = findViewById<RadioGroup>(R.id.radioGroup)
        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val temppassword=password.editText?.text.toString()
                val tempname=username.editText?.text.toString()
                val tempMobile=Mobile.editText?.text.toString()
                val temptvCity=tvCity.editText?.text.toString()
                val selectedId: Int = radioUserGroup.getCheckedRadioButtonId()
                radioUserButton = findViewById<View>(selectedId) as RadioButton
                when (radioUserButton.id) {
                    R.id.radioUser -> {
                        val entity= UserEntity(0, tempname,temppassword,tempMobile,temptvCity,UserType.valueOf("User").toString());
                        InsertTask(this@RegistratinActivity,entity).execute()
                    }
                    R.id.radioMechanic -> {
                    }
                    R.id.radioAdmin -> {
                        val intent = Intent(this@RegistratinActivity, AdminActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        })
    }

  @SuppressLint("StaticFieldLeak")
  inner  class InsertTask internal constructor(context: RegistratinActivity?, note: UserEntity) : AsyncTask<Void?, Void?, Boolean>() {
        private val activityReference: WeakReference<RegistratinActivity>
        private lateinit var note: UserEntity


        // onPostExecute runs on main thread
        override fun onPostExecute(bool: Boolean) {
            if (bool) {
                val intent = Intent(activityReference.get(), UserActivity::class.java)
                activityReference.get()?.startActivity(intent)
            }
        }
        init {
            activityReference=WeakReference(context)
            this.note =note
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            var isInserted: Boolean;
            try {
                activityReference.get()?.appDatabase?.userDao()?.insertAll(note);
                isInserted=true;

            }catch (e:Exception){
                isInserted=false;

            }
            return isInserted;
        }

    }
}

