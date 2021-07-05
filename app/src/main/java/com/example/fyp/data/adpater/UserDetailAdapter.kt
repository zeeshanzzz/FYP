package com.example.fyp.data.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.database.mechanic.enity.UserEntity

class UserDetailAdapter :RecyclerView.Adapter<UserDetailAdapter.UserDetailAdapterViewHolder>(){


    private lateinit var userDetailList: ArrayList<UserEntity>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_detail_item, parent, false)
        return UserDetailAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDetailAdapterViewHolder, position: Int) {

        try {

            var listItem = userDetailList.get(position)

            holder.tv_userDetailName.text = "Name "+listItem.email
            holder.tv_userDetailNumber.text = "Mobile # "+listItem.mobile
            holder.tv_userDetailCity.text = "City "+listItem.city

        } catch (e: Exception) {
            Log.e("FYP APP ======>", "Error " + e.message)
        }
    }

    override fun getItemCount(): Int {
        return userDetailList.size
    }

    public fun setUserDetail(userDetailList: List<UserEntity>?){
        this.userDetailList= userDetailList as ArrayList<UserEntity>
    }

    inner class UserDetailAdapterViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tv_userDetailName = itemView.findViewById<TextView>(R.id.tv_userDetailName)
        val tv_userDetailNumber = itemView.findViewById<TextView>(R.id.tv_userDetailNumber)
        val tv_userDetailCity = itemView.findViewById<TextView>(R.id.tv_userDetailCity)

    }

}