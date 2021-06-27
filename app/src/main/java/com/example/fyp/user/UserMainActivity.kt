package com.example.fyp.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fyp.R

class UserMainActivity : AppCompatActivity() {

    private lateinit var tv_userMainHome: TextView
    private lateinit var tv_userMainLogOut: TextView

    private lateinit var btn_userFindService:Button
    private lateinit var btn_userMyProfile:Button
    private lateinit var btn_userFeedback:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)
        init()
        listener()
    }

    private fun init() {

        tv_userMainHome = findViewById(R.id.tv_userMainHome);
        tv_userMainLogOut = findViewById(R.id.tv_userMainLogOut);

        btn_userFindService = findViewById(R.id.tv_userMainHome);
        btn_userMyProfile = findViewById(R.id.btn_userMyProfile);
        btn_userFeedback = findViewById(R.id.btn_userFeedback);
    }

    private fun listener() {
        tv_userMainHome.setOnClickListener {

        }

        tv_userMainLogOut.setOnClickListener {

        }

        btn_userFindService.setOnClickListener {

            startActivity(Intent(this@UserMainActivity,FindServiceActivity::class.java))
        }
        btn_userMyProfile.setOnClickListener {

            startActivity(Intent(this@UserMainActivity,UserProfileActivity::class.java))

        }
        btn_userFeedback.setOnClickListener {
            startActivity(Intent(this@UserMainActivity,PostFeedbackActivity::class.java))
        }
    }
}