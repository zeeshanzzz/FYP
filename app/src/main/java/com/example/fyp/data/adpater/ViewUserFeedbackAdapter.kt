package com.example.fyp.data.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.model.ViewUserFeedBack
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import com.example.fyp.database.mechanic.enity.UserEntity

class ViewUserFeedbackAdapter :RecyclerView.Adapter<ViewUserFeedbackAdapter.ViewUserFeedbackAdapterViewHolder>() {

    private lateinit var feedbackList:ArrayList<MechanicFeedBackEntity>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewUserFeedbackAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_user_feedback_item, parent, false)
        return ViewUserFeedbackAdapterViewHolder(view)
    }

    public fun setFeedbackList(feedbackList: List<MechanicFeedBackEntity>?) {
        this.feedbackList=feedbackList as ArrayList<MechanicFeedBackEntity>
    }

    override fun onBindViewHolder(holder: ViewUserFeedbackAdapterViewHolder, position: Int) {

        try {

            var listItem = feedbackList.get(position)

            holder.tv_ViewUserFeedBackId.text = listItem.id.toString()
            holder.tv_ViewUserFeedBackName.text = listItem.user_name
            holder.tv_ViewUserFeedBackDate.text = listItem.date
            holder.tv_ViewUserFeedBack.text = listItem.feedback

        } catch (e: Exception) {
            Log.e("FYP APP ======>", "Error " + e.message)
        }

    }

    override fun getItemCount(): Int {
        return  feedbackList.size
    }

    inner class ViewUserFeedbackAdapterViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tv_ViewUserFeedBackId = itemView.findViewById<TextView>(R.id.tv_ViewUserFeedBackId)
        val tv_ViewUserFeedBackName = itemView.findViewById<TextView>(R.id.tv_ViewUserFeedBackName)
        val tv_ViewUserFeedBackDate = itemView.findViewById<TextView>(R.id.tv_ViewUserFeedBackDate)
        val tv_ViewUserFeedBack = itemView.findViewById<TextView>(R.id.tv_ViewUserFeedBack)

    }
}