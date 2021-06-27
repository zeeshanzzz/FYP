package com.example.fyp.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.adpater.UserFindServiceAdapter
import com.example.fyp.data.model.UserFindServiceModal

class FindServiceActivity : AppCompatActivity() {

    private lateinit var iv_userFindServiceBack: ImageView

    private lateinit var rc_userFindService: RecyclerView

    private lateinit var sv_findService: SearchView

    private lateinit var serviceList: ArrayList<UserFindServiceModal>

    private lateinit var servicesAdapter: UserFindServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_service)

        init()
        showServicesList()
    }

    private fun init() {

        iv_userFindServiceBack = findViewById(R.id.iv_userFindServiceBack)
        rc_userFindService = findViewById(R.id.rc_userFindService)
        sv_findService = findViewById(R.id.sv_findService)

        servicesAdapter = UserFindServiceAdapter()

    }

    private fun listener() {


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

        if (serviceList.isEmpty().not()) {

            servicesAdapter.setUserServiceList(serviceList)
            rc_userFindService.adapter = servicesAdapter

        }

    }
}