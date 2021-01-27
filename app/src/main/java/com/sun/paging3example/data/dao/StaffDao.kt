package com.sun.paging3example.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sun.paging3example.data.model.Staff

@Dao
interface StaffDao {
    @Query("SELECT * FROM Staff ORDER BY staffId DESC")
    fun getPages(): PagingSource<Int, Staff>

    @Update
    suspend fun update(staff: Staff): Int

    @Insert
    suspend fun insert(staff: Staff): Long
}