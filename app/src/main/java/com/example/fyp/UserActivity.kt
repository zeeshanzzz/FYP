package com.example.fyp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import java.lang.Exception
import java.lang.ref.WeakReference

class UserActivity : AppCompatActivity() {
    lateinit var appDatabase: AppDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(findViewById(R.id.toolbar))
        appDatabase= AppDatabase.getInstance(this@UserActivity)!!
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            ListAllUsers(this).execute()
        }
    }
    private class ListAllUsers  constructor(context: UserActivity?) : AsyncTask<Void?, Void?, List<UserEntity>>() {
        private val activityReference: WeakReference<UserActivity>
      //  private val note: UserEntity


        // onPostExecute runs on main thread
        override fun onPostExecute(entity: List<UserEntity>?) {

        }

        // only retain a weak reference to the activity
        init {
            activityReference = WeakReference(context)
           /// this.note = note
        }

        override fun doInBackground(vararg params: Void?): List<UserEntity>? {

            var list: List<UserEntity>? =null
            try {
           list = activityReference.get()?.appDatabase?.userDao()?.getAll()


            }catch (e: Exception){
                list= ArrayList<UserEntity>();

            }
            return list;
        }

    }
}