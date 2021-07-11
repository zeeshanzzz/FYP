package com.example.fyp.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.fyp.R
import com.example.fyp.ui.login.LoginActivity

class UserMainActivity : AppCompatActivity() {

    private lateinit var tv_userMainHome: TextView
    private lateinit var btn_Logout: Button

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
        tv_userMainHome.visibility=View.GONE
        btn_Logout = findViewById(R.id.btn_Logout);

        btn_userFindService = findViewById(R.id.btn_userFindService);
        btn_userMyProfile = findViewById(R.id.btn_userMyProfile);
        btn_userFeedback = findViewById(R.id.btn_userFeedback);
    }

    private fun listener() {
        tv_userMainHome.setOnClickListener {

        }

        btn_Logout.setOnClickListener {
            startActivity(Intent(this@UserMainActivity,LoginActivity::class.java))
            finish()
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