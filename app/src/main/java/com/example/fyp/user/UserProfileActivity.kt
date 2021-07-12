package com.example.fyp.user

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.fyp.AdminActivity
import com.example.fyp.MechanicActivity
import com.example.fyp.R
import com.example.fyp.UserType
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import com.example.fyp.ui.login.LoginActivity
import com.example.fyp.ui.login.LoginActivity.Companion.userEmail
import java.lang.Exception
import java.lang.ref.WeakReference

class UserProfileActivity : AppCompatActivity() {
    lateinit var appDatabase: AppDatabase;
    private lateinit var iv_userProfileBack:ImageView

    private lateinit var tv_userProfileName:TextView

    private lateinit var tv_userProfileMobileNumber:TextView

    private lateinit var tv_userProfileCnic:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        appDatabase = AppDatabase.getInstance(this@UserProfileActivity)!!
        init()
        listener()
        LoginTask(this,userEmail)
    }

    private fun init(){

        iv_userProfileBack = findViewById(R.id.iv_userProfileBack)

        tv_userProfileName = findViewById(R.id.tv_userProfileName)
        tv_userProfileMobileNumber = findViewById(R.id.tv_userProfileMobileNumber)
        tv_userProfileCnic = findViewById(R.id.tv_userProfileCnic)


    }

    private fun listener(){

        iv_userProfileBack.setOnClickListener {
            onBackPressed()
        }
    }
    @SuppressLint("StaticFieldLeak")
    inner class LoginTask internal constructor(context: UserProfileActivity?, email: String) :
        AsyncTask<Void?, Void?, UserEntity>() {
        private val activityReference: WeakReference<UserProfileActivity>

        // private lateinit var note: UserEntity
        private lateinit var email: String

        override fun onPostExecute(result: UserEntity?) {
            super.onPostExecute(result)
            if(result!=null){

                tv_userProfileName.setText(result.email)
                tv_userProfileMobileNumber.setText(result.mobile)
            }
        }


        init {
            activityReference = WeakReference(context)
            // this.note =note
            this.email = email
        }

        override fun doInBackground(vararg params: Void?): UserEntity? {
            var isUserExist: UserEntity?=null
            try {
                val entity: UserEntity? =
                    activityReference.get()?.appDatabase?.userDao()?.findByEmail(email)
                if (!entity?.email.isNullOrEmpty()) {
                    if (entity != null) {
                        isUserExist =entity
                    }
                }

            } catch (e: Exception) {


            }
            return isUserExist;
        }

    }


}