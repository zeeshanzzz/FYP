package com.example.fyp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.*
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import com.example.fyp.ui.login.LoginActivity
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDatabase = AppDatabase.getInstance(this@MainActivity)!!
        val entity = UserEntity(
            0,
            "admin",
            "admin123",
            "1234567",
            "Temp",
            UserType.valueOf("Admin").toString()
        );
        InsertAdmin(this@MainActivity, entity).execute()

        Handler().postDelayed(
            Runnable {
                val intent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish();

            }, 4000
        )


    }
    @SuppressLint("StaticFieldLeak")
    inner class InsertAdmin internal constructor(context: MainActivity?, note: UserEntity) :
        AsyncTask<Void?, Void?, Boolean>() {
        private val activityReference: WeakReference<MainActivity>
        private lateinit var note: UserEntity


        // onPostExecute runs on main thread


        init {
            activityReference = WeakReference(context)
            this.note = note
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            var isInserted: Boolean;
            try {
                activityReference.get()?.appDatabase?.userDao()?.insertAll(note);
                isInserted = true;
                Log.e("FYP------->>", "Admin Inserted")

            } catch (e: Exception) {
                isInserted = false;

            }
            return isInserted;
        }

    }

}