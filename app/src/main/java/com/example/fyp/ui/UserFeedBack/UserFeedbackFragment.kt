package com.example.fyp.ui.UserFeedBack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.adpater.ViewUserFeedbackAdapter
import com.example.fyp.data.model.ViewUserFeedBack


class UserFeedbackFragment : Fragment() {

    private lateinit var root:View

    private lateinit var iv_viewUserFeedBack: ImageView

    private lateinit var sv_viewUserFeedBack: androidx.appcompat.widget.SearchView

    private lateinit var feedList:ArrayList<ViewUserFeedBack>

    private lateinit var feedbackAdapter: ViewUserFeedbackAdapter
    private lateinit var rc_viewUserFeedback: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.activity_view_user_feedback, container, false)
        init()
        return root
    }

    private fun init(){

        iv_viewUserFeedBack = root.findViewById(R.id.iv_viewUserFeedBack)
        sv_viewUserFeedBack = root.findViewById(R.id.sv_viewUserFeedBack)
        rc_viewUserFeedback = root.findViewById(R.id.rc_viewUserFeedback)

        sv_viewUserFeedBack.visibility=View.GONE

        feedList=ArrayList<ViewUserFeedBack>()
        feedbackAdapter=  ViewUserFeedbackAdapter()
        getFeedbackList()
    }

    private fun getFeedbackList(){

        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))
        feedList.add(ViewUserFeedBack("1","Test","27/06/2021","Good one"))

        if (feedList.isEmpty().not()){
            feedbackAdapter= ViewUserFeedbackAdapter()
            feedbackAdapter.setFeedbackList(feedList)
            showFeedbackList()
        }
    }

    private fun showFeedbackList(){
        rc_viewUserFeedback.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        rc_viewUserFeedback.setHasFixedSize(true)
        rc_viewUserFeedback.adapter = feedbackAdapter
    }

    private fun listener(){

        /*iv_viewUserFeedBack.setOnClickListener {
            onBackPressed()
        }*/
    }

}