package com.example.fyp.user

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.fyp.MechanicActivity
import com.example.fyp.R
import com.example.fyp.RegistratinActivity
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import com.example.fyp.database.mechanic.enity.UserEntity
import java.lang.ref.WeakReference

class PostFeedbackActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase;
    private lateinit var iv_userFeedbackBack:ImageView

    private lateinit var et_userProfileUserId:EditText

    private lateinit var et_userProfileUserName:EditText

    private lateinit var et_userProfileUserDate:EditText

    private lateinit var et_userProfileUserFeedback:EditText

    private lateinit var btn_submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_feedback)
        appDatabase = AppDatabase.getInstance(this@PostFeedbackActivity)!!

        init()
        listener()
    }

    private fun init(){

        iv_userFeedbackBack=findViewById(R.id.iv_userFeedbackBack)

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
InsertTask(this, MechanicFeedBackEntity(et_userProfileUserId.text.toString().toInt(),et_userProfileUserName.text.toString()
,et_userProfileUserDate.text.toString(),et_userProfileUserFeedback.text.toString()

)).execute()
    }
    @SuppressLint("StaticFieldLeak")
    inner class InsertTask internal constructor(context: PostFeedbackActivity?, note: MechanicFeedBackEntity) :
        AsyncTask<Void?, Void?, Boolean>() {
        private val activityReference: WeakReference<PostFeedbackActivity>
        private lateinit var note: MechanicFeedBackEntity


        // onPostExecute runs on main thread
        override fun onPostExecute(bool: Boolean) {
            if (bool) {
     Toast.makeText(activityReference.get(),"FeedBack Inseretd",Toast.LENGTH_LONG).show()

            }
        }

        init {
            activityReference = WeakReference(context)
            this.note = note
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            var isInserted: Boolean;
            try {
                activityReference.get()?.appDatabase?.mechanicFeedbackDao()?.insertAll(note);
                isInserted = true;

            } catch (e: Exception) {
                isInserted = false;

            }
            return isInserted;
        }

    }
}