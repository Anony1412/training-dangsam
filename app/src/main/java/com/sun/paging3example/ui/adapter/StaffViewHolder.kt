package com.sun.paging3example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.paging3example.R
import com.sun.paging3example.data.model.Staff
import kotlinx.android.synthetic.main.item_staff.view.*

class StaffViewHolder(
    parent: ViewGroup
): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
) {
    fun bind(staff: Staff?) {
        itemView.apply {
            textStaffId.text = staff?.staffId.toString()
            textStaffName.text = staff?.name
        }
    }
}