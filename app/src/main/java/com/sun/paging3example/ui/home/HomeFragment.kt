package com.sun.paging3example.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.sun.paging3example.R
import com.sun.paging3example.data.database.AppDatabase
import com.sun.paging3example.data.model.Staff
import com.sun.paging3example.ui.adapter.StaffAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private val staffAdapter by lazy {
        StaffAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepareData()
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        recyclerViewStaff.adapter = staffAdapter
        lifecycleScope.launch {
            viewModel.items.collectLatest {
                staffAdapter.submitData(it)
            }
        }
    }

    private fun prepareData() {
        context?.let{
            val dao = Room.databaseBuilder(it, AppDatabase::class.java, "StaffDatabase")
                .build()
                .staffDao()
            GlobalScope.launch {
                for (i in 0..100) {
                    dao.insert(Staff(0, "Staff"))
                }
            }
        }
    }
}