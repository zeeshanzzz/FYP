package com.example.fyp.data.adpater

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.model.UserFindServiceModal


class UserFindServiceAdapter :
    RecyclerView.Adapter<UserFindServiceAdapter.UserFindServiceAdapterViewHolder>() {

    private lateinit var userFindServiceList: ArrayList<UserFindServiceModal>


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserFindServiceAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_find_service_list_item, parent, false)
        return UserFindServiceAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserFindServiceAdapterViewHolder, position: Int) {

        try {

            var listItem = userFindServiceList.get(position)

            holder.tv_itemMechenicName.text = listItem.mechenicName
            holder.tv_itemEmail.text = listItem.email
            holder.tv_itemWorkType.text = listItem.workType
            holder.tv_itemCity.text = listItem.city
            holder.tv_itemAddress.text = listItem.address

            holder.btn_userFindServiceCall.setOnClickListener {

                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:${listItem.phoneNumber}")
                holder.itemView.context.startActivity(callIntent)

                //Toast.makeText(holder.itemView.context, "Call Button Clicked", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Log.e("FYP APP ======>", "Error " + e.message)
        }

    }

    override fun getItemCount(): Int {
        return userFindServiceList.size
    }

    public fun setUserServiceList(servicesList: ArrayList<UserFindServiceModal>) {
        this.userFindServiceList = servicesList
    }

    inner class UserFindServiceAdapterViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tv_itemMechenicName = itemView.findViewById<TextView>(R.id.tv_itemMechenicName)
        val tv_itemEmail = itemView.findViewById<TextView>(R.id.tv_itemEmail)
        val tv_itemWorkType = itemView.findViewById<TextView>(R.id.tv_itemWorkType)
        val tv_itemCity = itemView.findViewById<TextView>(R.id.tv_itemCity)
        val tv_itemAddress = itemView.findViewById<TextView>(R.id.tv_itemAddress)
        val btn_userFindServiceCall = itemView.findViewById<Button>(R.id.btn_userFindServiceCall)

    }
}