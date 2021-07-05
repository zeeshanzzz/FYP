package com.example.fyp.user

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.*
import com.example.fyp.data.adpater.UserFindServiceAdapter
import com.example.fyp.data.model.UserFindServiceModal
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.MechanicEnity
import com.example.fyp.database.mechanic.enity.UserEntity
import java.lang.ref.WeakReference

class FindServiceActivity : AppCompatActivity() {

    private lateinit var iv_userFindServiceBack: ImageView
    lateinit var appDatabase: AppDatabase;
    private lateinit var rc_userFindService: RecyclerView

    private lateinit var sv_findService: androidx.appcompat.widget.SearchView

    private lateinit var serviceList: ArrayList<UserFindServiceModal>

    private lateinit var servicesAdapter: UserFindServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_service)
        appDatabase = AppDatabase.getInstance(this@FindServiceActivity)!!

        init()
        listener()
        showServicesList()
    }

    private fun init() {

        iv_userFindServiceBack = findViewById(R.id.iv_userFindServiceBack)
        rc_userFindService = findViewById(R.id.rc_userFindService)
        sv_findService = findViewById(R.id.sv_findService)
        sv_findService.visibility= View.GONE

        serviceList= ArrayList<UserFindServiceModal>()
        servicesAdapter = UserFindServiceAdapter()

    }

    private fun listener() {
        iv_userFindServiceBack.setOnClickListener { onBackPressed() }
    }

    private fun getServicesList() {

        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )

        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )

        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )
        serviceList.add(
            UserFindServiceModal(
                "1",
                "One",
                "One",
                "Type 1",
                "Lahore",
                "Johar Town Lahore",
                "03241234567"
            )
        )


    }

    private fun showServicesList() {

        getServicesList()

        rc_userFindService.layoutManager = LinearLayoutManager(
            this@FindServiceActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_userFindService.setHasFixedSize(true)
        UserDetailsTask(this).execute()
//        if (serviceList.isEmpty().not()) {
//
//            servicesAdapter.setUserServiceList(serviceList)
//            rc_userFindService.adapter = servicesAdapter
//
//        }

    }
    //@SuppressLint("StaticFieldLeak")
//    inner class InsertTask internal constructor(context: FindServiceActivity?, note: UserEntity) :
//        AsyncTask<Void?, Void?, Boolean>() {
//        private val activityReference: WeakReference<FindServiceActivity>
//        private lateinit var note: UserEntity
//
//
//        // onPostExecute runs on main thread
//        override fun onPostExecute(bool: Boolean) {
//            if (bool) {
//
//                when (radioUserButton.id) {
//                    R.id.radioUser -> {
//                        val intent = Intent(activityReference.get(), UserMainActivity::class.java)
//                        activityReference.get()?.startActivity(intent)
//                    }
//                    R.id.radioMechanic -> {
//                        val intent = Intent(activityReference.get(), MechanicActivity::class.java)
//                        activityReference.get()?.startActivity(intent)
//                    }
//                    R.id.radioAdmin -> {
//                        val intent = Intent(activityReference.get(), AdminActivity::class.java)
//                        activityReference.get()?.startActivity(intent)
//                    }
//                }
//            }
//        }
//
//        init {
//            activityReference = WeakReference(context)
//            this.note = note
//        }
//
//        override fun doInBackground(vararg params: Void?): Boolean {
//            var isInserted: Boolean;
//            try {
//                activityReference.get()?.appDatabase?.userDao()?.insertAll(note);
//                isInserted = true;
//
//            } catch (e: Exception) {
//                isInserted = false;
//
//            }
//            return isInserted;
//        }
//
//    }
    @SuppressLint("StaticFieldLeak")
    inner class UserDetailsTask internal constructor(context: FindServiceActivity?) :
        AsyncTask<Void?, Void?, List<MechanicEnity>>() {
        private val activityReference: WeakReference<FindServiceActivity>

        // private lateinit var note: UserEntity
        private lateinit var email: String
        override fun onPostExecute(result: List<MechanicEnity>?) {
            super.onPostExecute(result)
            if (result?.isEmpty()?.not()!!) {

                servicesAdapter.setUserServiceList(result as ArrayList<MechanicEnity>)
                rc_userFindService.adapter = servicesAdapter

            }
        }


        init {
            activityReference = WeakReference(context)
            // this.note =note
        }

        override fun doInBackground(vararg params: Void?): List<MechanicEnity> {
            var  entity:List<MechanicEnity> = ArrayList<MechanicEnity>()
            try {
                entity= activityReference.get()?.appDatabase?.mechanicDao()?.findByTitle(UserType.Approve.name)!!


            } catch (e: java.lang.Exception) {



            }
            finally {
                return entity;
            }

        }

    }
}