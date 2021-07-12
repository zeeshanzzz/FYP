package com.example.fyp.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.fyp.R
import com.example.fyp.database.mechanic.AppDatabase

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


}