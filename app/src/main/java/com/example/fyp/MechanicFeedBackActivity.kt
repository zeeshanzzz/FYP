package com.example.fyp

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.data.adpater.ViewUserFeedbackAdapter
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import java.lang.ref.WeakReference

class MechanicFeedBackActivity : AppCompatActivity() {
    lateinit var appDatabase: AppDatabase;
    private lateinit var feedbackAdapter: ViewUserFeedbackAdapter
    private lateinit var rc_viewUserFeedback: RecyclerView
    lateinit var  searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_feed_back)
        appDatabase = AppDatabase.getInstance(this@MechanicFeedBackActivity)!!
        searchView =  findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
}
    private fun init(){


        rc_viewUserFeedback = findViewById(R.id.rc_viewUserFeedback)

        feedbackAdapter=  ViewUserFeedbackAdapter()
        getFeedbackList()
    }
    private fun getFeedbackList(){

//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
//
//        if (feedList.isEmpty().not()){
//            feedbackAdapter= ViewUserFeedbackAdapter()
//            feedbackAdapter.setFeedbackList(feedList)
//            showFeedbackList()
//        }
        UserDetailsTask (this).execute()
    }
    private fun showFeedbackList(){
        rc_viewUserFeedback.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_viewUserFeedback.setHasFixedSize(true)
        rc_viewUserFeedback.adapter = feedbackAdapter
    }
    @SuppressLint("StaticFieldLeak")
    inner class UserDetailsTask internal constructor(context: MechanicFeedBackActivity) :
        AsyncTask<Void?, Void?, List<MechanicFeedBackEntity>>() {
        private val activityReference: WeakReference<MechanicFeedBackActivity>

        // private lateinit var note: UserEntity
        //  private lateinit var email: String


        override fun onPostExecute(result: List<MechanicFeedBackEntity>?) {
            super.onPostExecute(result)
            if (result?.isEmpty()!!.not()){
                feedbackAdapter= ViewUserFeedbackAdapter()
                feedbackAdapter.setFeedbackList(result)
                showFeedbackList()
            }

        }

        init {
            activityReference = WeakReference(context)
            // this.note =note
            // this.email = email
        }

        override fun doInBackground(vararg params: Void?): List<MechanicFeedBackEntity> {
            var  entity: List<MechanicFeedBackEntity> = ArrayList()
            try {
                entity= activityReference.get()?.appDatabase?.mechanicFeedbackDao()?.getAll()!!


            } catch (e: java.lang.Exception) {



            }
            finally {
                return entity;
            }

        }

    }
}