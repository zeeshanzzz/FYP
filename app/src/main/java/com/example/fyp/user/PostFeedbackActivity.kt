package com.example.fyp.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.example.fyp.R

class PostFeedbackActivity : AppCompatActivity() {


    private lateinit var iv_userFeedbackBack:ImageView

    private lateinit var et_userProfileUserId:EditText

    private lateinit var et_userProfileUserName:EditText

    private lateinit var et_userProfileUserDate:EditText

    private lateinit var et_userProfileUserFeedback:EditText

    private lateinit var btn_submit:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_feedback)

        init()
        listener()
    }

    private fun init(){

        iv_userFeedbackBack=findViewById(R.id.iv_userProfileBack)

        et_userProfileUserId=findViewById(R.id.et_userProfileUserId)

        et_userProfileUserName=findViewById(R.id.et_userProfileUserName)

        et_userProfileUserDate=findViewById(R.id.et_userProfileUserDate)

        et_userProfileUserFeedback=findViewById(R.id.et_userProfileUserFeedback)

        btn_submit=findViewById(R.id.btn_submit)

    }

    private fun listener(){

        iv_userFeedbackBack.setOnClickListener {
            onBackPressed()
        }

        btn_submit.setOnClickListener {

            validation()
        }
    }

    private fun validation(){

        if(et_userProfileUserId.text.isEmpty()){
            et_userProfileUserId.error="Required"
            return
        }
        if(et_userProfileUserName.text.isEmpty()){
            et_userProfileUserName.error="Required"
            return
        }
        if(et_userProfileUserFeedback.text.isEmpty()){
            et_userProfileUserFeedback.error="Required"
            return
        }

        saveFeedback()
    }

    private fun saveFeedback(){

    }
}