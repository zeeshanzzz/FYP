package com.example.fyp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.MechanicEnity
import com.example.fyp.database.mechanic.enity.UserEntity
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.lang.ref.WeakReference

class MehanicBusinessActivity2 : AppCompatActivity() {
    lateinit var appDatabase: AppDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mehanic_business2)
        appDatabase= AppDatabase.getInstance(this@MehanicBusinessActivity2)!!
        val mechName = findViewById<TextInputLayout>(R.id.mechName)
        val mechEmail = findViewById<TextInputLayout>(R.id.mechEmail)
        val mechWorkType = findViewById<TextInputLayout>(R.id.mechWorkType)
        val mechCity = findViewById<TextInputLayout>(R.id.mechCity)
        val mechLicense = findViewById<TextInputLayout>(R.id.mechLicense)
        val btnCreateBusiness  = findViewById<Button>(R.id.btnCreateBusiness)
        btnCreateBusiness.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val temppmechName=mechName.editText?.text.toString()
                val temppmechEmaile=mechEmail.editText?.text.toString()
                val temppmechWorkType=mechWorkType.editText?.text.toString()
                val tempmechCity=mechCity.editText?.text.toString()
                val tempmechLicense=mechLicense.editText?.text.toString()
                val entity= MechanicEnity(0, temppmechName,temppmechEmaile,temppmechWorkType,tempmechCity,"Abc",tempmechLicense,UserType.Pending.name);
                InsertTask(this@MehanicBusinessActivity2,entity).execute()
            }


        })
    }
    @SuppressLint("StaticFieldLeak")
    inner  class InsertTask internal constructor(context: MehanicBusinessActivity2?, note: MechanicEnity) : AsyncTask<Void?, Void?, Boolean>() {
        private val activityReference: WeakReference<MehanicBusinessActivity2>
        private lateinit var note: MechanicEnity


        // onPostExecute runs on main thread
        override fun onPostExecute(bool: Boolean) {
            if (bool) {
//                val intent = Intent(activityReference.get(), UserActivity::class.java)
//                activityReference.get()?.startActivity(intent)
            }
        }
        init {
            activityReference= WeakReference(context)
            this.note =note
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            var isInserted: Boolean;
            try {
                activityReference.get()?.appDatabase?.mechanicDao()?.insertAll(note);
                isInserted=true;

            }catch (e: Exception){
                isInserted=false;

            }
            return isInserted;
        }

    }
}