package com.sun.paging3example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sun.paging3example.data.dao.StaffDao
import com.sun.paging3example.data.model.Staff

@Database(entities = [Staff::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun staffDao(): StaffDao
}