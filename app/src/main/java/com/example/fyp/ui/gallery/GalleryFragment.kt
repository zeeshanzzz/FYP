package com.example.fyp.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.service.media.MediaBrowserService
import android.util.Log
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
import com.example.fyp.R
import com.example.fyp.admin.UserDetailActivity
import com.example.fyp.data.adpater.UserDetailAdapter
import com.example.fyp.data.model.UserDetail

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    private lateinit var iv_userDetailBack: ImageView

    private lateinit var sv_userDetail: androidx.appcompat.widget.SearchView

    private lateinit var rc_userDetail: RecyclerView

    private lateinit var userDetailList: ArrayList<UserDetail>

    private lateinit var userDetailAdapter: UserDetailAdapter

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* galleryViewModel =
                 ViewModelProvider(this).get(GalleryViewModel::class.java)*/
        root = inflater.inflate(R.layout.fragment_gallery, container, false)
        init()
        //listener()
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //startActivity(Intent(requireContext(),UserDetailActivity::class.java))
    }

    private fun init() {

        try {
            iv_userDetailBack = root.findViewById(R.id.iv_userDetailBack)
            sv_userDetail = root.findViewById(R.id.sv_userDetail)
            rc_userDetail = root.findViewById(R.id.rc_userDetail)

            sv_userDetail.visibility=View.GONE

            userDetailList=ArrayList<UserDetail>()
            userDetailAdapter = UserDetailAdapter()
            getUserDetailList()
        } catch (e: Exception) {
            Log.e("App", "Error " + e.message)
        }

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

        if (userDetailList.isEmpty().not()) {
            userDetailAdapter.setUserDetail(userDetailList)
            showUserDetailList()
        }
    }

    private fun showUserDetailList() {
        rc_userDetail.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_userDetail.setHasFixedSize(true)
        rc_userDetail.adapter = userDetailAdapter

    }

    private fun listener() {

        iv_userDetailBack.setOnClickListener {
            //
            // root.onBackPressed()
        }
    }
}