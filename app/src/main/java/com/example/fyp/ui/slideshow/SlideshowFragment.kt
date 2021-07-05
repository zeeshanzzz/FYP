package com.example.fyp.ui.slideshow

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.AdminActivity
import com.example.fyp.R
import com.example.fyp.data.adpater.ApproveBusinessListAdapter
import com.example.fyp.data.adpater.ItemClickListner
import com.example.fyp.data.model.ApproveBusiness
import com.example.fyp.database.mechanic.enity.MechanicEnity
import com.example.fyp.database.mechanic.enity.UserEntity
import java.lang.ref.WeakReference

class SlideshowFragment : Fragment() ,ItemClickListner {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var root:View

    private lateinit var iv_adminApproveBusinessBack: ImageView
    private lateinit var sv_adminApproveBusiness: androidx.appcompat.widget.SearchView
    private lateinit var rc_adminApproveBusiness: RecyclerView

    private lateinit var businessList: ArrayList<ApproveBusiness>

    private lateinit var businessAdapter: ApproveBusinessListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProvider(this).get(SlideshowViewModel::class.java)
        root = inflater.inflate(R.layout.activity_approve_business_activty, container, false)
        init()
        return root
    }
    private fun init() {

        iv_adminApproveBusinessBack = root.findViewById(R.id.iv_adminApproveBusinessBack)
        sv_adminApproveBusiness = root.findViewById(R.id.sv_adminApproveBusiness)
        rc_adminApproveBusiness = root.findViewById(R.id.rc_adminApproveBusiness)

        sv_adminApproveBusiness.visibility=View.GONE

        businessList=ArrayList<ApproveBusiness>()
        businessAdapter= ApproveBusinessListAdapter()

        getBusinessList()
    }

    private fun getBusinessList(){

//        businessList.add(ApproveBusiness("1","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("2","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("3","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("4","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("5","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("6","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("7","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("8","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//        businessList.add(ApproveBusiness("9","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
//
//        if (businessList.isEmpty().not()) {
//            businessAdapter.setBusinessList(businessList)
//            showBusinessList()
//        }
        GetAllBuiness(activity as AdminActivity).execute()

    }

    private fun listener() {

       /* iv_adminApproveBusinessBack.setOnClickListener {
            onBackPressed()
        }*/
    }
    private fun showBusinessList(){
        rc_adminApproveBusiness.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_adminApproveBusiness.setHasFixedSize(true)
        rc_adminApproveBusiness.adapter = businessAdapter
    }
    @SuppressLint("StaticFieldLeak")
    inner class GetAllBuiness internal constructor(context: AdminActivity?) :
        AsyncTask<Void?, Void?, List<MechanicEnity>>() {
        private val activityReference: WeakReference<AdminActivity>

        // private lateinit var note: UserEntity
       // private lateinit var email: String


        override fun onPostExecute(result: List<MechanicEnity>?) {
            super.onPostExecute(result)

            if (result?.isEmpty()?.not()!!) {
                businessAdapter.setBusinessList(result as ArrayList<MechanicEnity>)
                showBusinessList()
            }
        }

        init {
            activityReference = WeakReference(context)
            // this.note =note
           // this.email = email
        }

        override fun doInBackground(vararg params: Void?): List<MechanicEnity> {
            var  entity: List<MechanicEnity> = ArrayList()
            try {
                entity= activityReference.get()?.appDatabase?.mechanicDao()?.getAll()!!


            } catch (e: java.lang.Exception) {



            }
            finally {
                return entity;
            }

        }

    }
        @SuppressLint("StaticFieldLeak")
    inner class UserDetailsTask internal constructor(context: AdminActivity?,approve:String,email:String) :
        AsyncTask<Void?, Void?,String>() {
        private val activityReference: WeakReference<AdminActivity>
        private lateinit var approve:String
            private lateinit var email:String;

        // private lateinit var note: UserEntity
        // private lateinit var email: String


            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
            }

        init {
            this.approve=approve
            this.email=email
            activityReference = WeakReference(context)
            // this.note =note
            // this.email = email
        }

        override fun doInBackground(vararg params: Void?): String? {

            try {
              activityReference.get()?.appDatabase?.mechanicDao()?.update(approve,email)!!


            } catch (e: java.lang.Exception) {



            }
            return "void"
        }

    }


    override fun onItemClick(item: String, mail: String) {
        UserDetailsTask(activity as AdminActivity,item,mail).execute()

    }
}