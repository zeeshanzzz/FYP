package com.example.fyp.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.adpater.UserDetailAdapter
import com.example.fyp.data.model.UserDetail

class UserDetailActivity : AppCompatActivity() {

    private lateinit var iv_userDetailBack: ImageView

    private lateinit var sv_userDetail: SearchView

    private lateinit var rc_userDetail: RecyclerView

    private lateinit var userDetailList: ArrayList<UserDetail>

    private lateinit var userDetailAdapter: UserDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        init()
        listener()
    }

    private fun init() {

        iv_userDetailBack = findViewById(R.id.iv_userDetailBack)
        sv_userDetail = findViewById(R.id.sv_userDetail)
        rc_userDetail = findViewById(R.id.rc_userDetail)

        userDetailAdapter = UserDetailAdapter()
        getUserDetailList()

    }

    private fun getUserDetailList() {
        userDetailList.add(UserDetail("1", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("2", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("3", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("4", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("5", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("6", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("7", "Test", "03241234567", "Lahore"))
        userDetailList.add(UserDetail("8", "Test", "03241234567", "Lahore"))

//        if (userDetailList.isEmpty().not()) {
//            userDetailAdapter.setUserDetail(userDetailList)
//            showUserDetailList()
//        }
    }

    private fun showUserDetailList() {
        rc_userDetail.layoutManager = LinearLayoutManager(
            this@UserDetailActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_userDetail.setHasFixedSize(true)
        rc_userDetail.adapter = userDetailAdapter

    }

    private fun listener() {

        iv_userDetailBack.setOnClickListener {
            onBackPressed()
        }
    }
}