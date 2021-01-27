package com.sun.paging3example.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.sun.paging3example.data.model.Staff

class StaffAdapter: PagingDataAdapter<Staff, StaffViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Staff>() {
            override fun areItemsTheSame(oldItem: Staff, newItem: Staff): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Staff, newItem: Staff): Boolean {
                return oldItem.staffId == newItem.staffId
            }
        }
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        return StaffViewHolder(parent)
    }
}