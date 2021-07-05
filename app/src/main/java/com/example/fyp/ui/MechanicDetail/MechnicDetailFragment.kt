package com.example.fyp.ui.MechanicDetail

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.AdminActivity
import com.example.fyp.R
import com.example.fyp.UserType
import com.example.fyp.data.adpater.UserDetailAdapter
import com.example.fyp.data.model.UserDetail
import com.example.fyp.database.mechanic.AppDatabase
import com.example.fyp.database.mechanic.enity.UserEntity
import java.lang.ref.WeakReference

class MechnicDetailFragment : Fragment() {

    private lateinit var iv_userDetailBack: ImageView

    private lateinit var sv_userDetail: SearchView

    private lateinit var rc_mechanicDetail: RecyclerView

    private lateinit var userDetailList: ArrayList<UserDetail>

    private lateinit var userDetailAdapter: UserDetailAdapter
    private lateinit var root:View
    lateinit var appDatabase: AppDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_mechnic_detail, container, false)
        appDatabase = AppDatabase.getInstance(activity)!!
        init()
        return root;
    }

    private fun init() {

        iv_userDetailBack = root.findViewById(R.id.iv_mechanicDetailBack)
      //  sv_userDetail = root.findViewById(R.id.sv_userDetail)
        rc_mechanicDetail = root.findViewById(R.id.rc_mechanicDetail)

        userDetailAdapter = UserDetailAdapter()
        UserDetailsTask(activity as AdminActivity, UserType.User.name).execute()
       // getUserDetailList()
    }

    @SuppressLint("StaticFieldLeak")
    inner class UserDetailsTask internal constructor(context: AdminActivity?, email: String) :
        AsyncTask<Void?, Void?, List<UserEntity>>() {
        private val activityReference: WeakReference<AdminActivity>

        // private lateinit var note: UserEntity
        private lateinit var email: String


        override fun onPostExecute(result: List<UserEntity>?) {
            super.onPostExecute(result)
            if (result?.isEmpty()!!.not()) {
                userDetailAdapter.setUserDetail(result)
                showUserDetailList()
            }
        }

        init {
            activityReference = WeakReference(context)
            // this.note =note
            this.email = email
        }

        override fun doInBackground(vararg params: Void?): List<UserEntity> {
            var  entity: List<UserEntity> = ArrayList()
            try {
                entity= activityReference.get()?.appDatabase?.userDao()?.findByUserType(email)!!


            } catch (e: java.lang.Exception) {



            }
            finally {
                return entity;
            }

        }

    }

    private fun showUserDetailList() {
        rc_mechanicDetail.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_mechanicDetail.setHasFixedSize(true)
        rc_mechanicDetail.adapter = userDetailAdapter

    }

}