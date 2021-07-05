package com.example.fyp.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.adpater.ApproveBusinessListAdapter
import com.example.fyp.data.model.ApproveBusiness

class ApproveBusinessActivty : AppCompatActivity() {

    private lateinit var iv_adminApproveBusinessBack: ImageView
    private lateinit var sv_adminApproveBusiness: SearchView
    private lateinit var rc_adminApproveBusiness: RecyclerView

    private lateinit var businessList: ArrayList<ApproveBusiness>

    private lateinit var businessAdapter: ApproveBusinessListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_approve_business_activty)

        init()
        listener()
    }

    private fun init() {

        iv_adminApproveBusinessBack = findViewById(R.id.iv_adminApproveBusinessBack)
        sv_adminApproveBusiness = findViewById(R.id.sv_adminApproveBusiness)
        rc_adminApproveBusiness = findViewById(R.id.rc_adminApproveBusiness)

        businessList=ArrayList<ApproveBusiness>()
        businessAdapter= ApproveBusinessListAdapter()

        getBusinessList()
    }

    private fun getBusinessList(){

        businessList.add(ApproveBusiness("1","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("2","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("3","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("4","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("5","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("6","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("7","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("8","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))
        businessList.add(ApproveBusiness("9","Test","test@gmail.com","Type one","Lahore","Johar Town","1234567",""))

        if (businessList.isEmpty().not()) {
         //   businessAdapter.setBusinessList(businessList)
            showBusinessList()
        }
    }

    private fun listener() {

        iv_adminApproveBusinessBack.setOnClickListener {
            onBackPressed()
        }
    }
    private fun showBusinessList(){
        rc_adminApproveBusiness.layoutManager = LinearLayoutManager(
            this@ApproveBusinessActivty,
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_adminApproveBusiness.setHasFixedSize(true)
        rc_adminApproveBusiness.adapter = businessAdapter
    }
}