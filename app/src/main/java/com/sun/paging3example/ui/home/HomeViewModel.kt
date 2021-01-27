package com.sun.paging3example.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.sun.paging3example.data.database.AppDatabase

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val dao = Room.databaseBuilder(app, AppDatabase::class.java, "StaffDatabase")
        .build()
        .staffDao()

    val items = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = true,
            maxSize = 200
        )
    ) {
        dao.getPages()
    }.flow
}