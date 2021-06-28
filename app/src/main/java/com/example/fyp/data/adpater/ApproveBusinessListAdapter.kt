package com.example.fyp.data.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.R
import com.example.fyp.data.model.ApproveBusiness


class ApproveBusinessListAdapter :
    RecyclerView.Adapter<ApproveBusinessListAdapter.ApproveBusinessListAdapterViewHolder>() {

    private lateinit var businessList: ArrayList<ApproveBusiness>

    private val SELECT_STATUS: String = "Select Status"

    public fun setBusinessList(businessList: ArrayList<ApproveBusiness>) {
        this.businessList = businessList
    }


    inner class ApproveBusinessListAdapterViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tv_approveBusinessMechenicName =
            itemView.findViewById<TextView>(R.id.tv_approveBusinessMechenicName)
        val tv_approveBusinessEmail = itemView.findViewById<TextView>(R.id.tv_approveBusinessEmail)
        val tv_approveBusinessWorkType =
            itemView.findViewById<TextView>(R.id.tv_approveBusinessWorkType)
        val tv_approveBusinessCity = itemView.findViewById<TextView>(R.id.tv_approveBusinessCity)
        val tv_approveBusinessAddress =
            itemView.findViewById<TextView>(R.id.tv_approveBusinessAddress)
        val tv_approveBusinessLiscense =
            itemView.findViewById<TextView>(R.id.tv_approveBusinessLiscense)
        val sp_approveBusinessStatus = itemView.findViewById<Spinner>(R.id.sp_approveBusinessStatus)
        val btn_approveBusinessSave = itemView.findViewById<Button>(R.id.btn_approveBusinessSave)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApproveBusinessListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.approve_business_list_item, parent, false)
        return ApproveBusinessListAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return businessList.size
    }

    override fun onBindViewHolder(holder: ApproveBusinessListAdapterViewHolder, position: Int) {

        try {

            var listItem = businessList.get(position)

            holder.tv_approveBusinessAddress.text = listItem.address
            holder.tv_approveBusinessMechenicName.text = listItem.name
            holder.tv_approveBusinessWorkType.text = listItem.workType
            holder.tv_approveBusinessLiscense.text = listItem.license_no
            holder.tv_approveBusinessEmail.text = listItem.email
            holder.tv_approveBusinessCity.text = listItem.city

            holder.sp_approveBusinessStatus.setOnItemSelectedListener(object :
                OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    if ((holder.sp_approveBusinessStatus.selectedItem == SELECT_STATUS).not()) {
                        holder.btn_approveBusinessSave.visibility = View.VISIBLE
                    } else {
                        holder.btn_approveBusinessSave.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {
                    return
                }
            })



            holder.btn_approveBusinessSave.setOnClickListener {
                updateBusinessStatus(listItem.city,holder.sp_approveBusinessStatus.selectedItem.toString())
            }

        } catch (e: Exception) {
            Log.e("FYP APP ======>", "Error " + e.message)
        }

    }

    private fun updateBusinessStatus( id:String, status:String) {

    }
}