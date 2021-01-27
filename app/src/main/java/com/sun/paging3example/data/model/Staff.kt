package com.sun.paging3example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Staff(
    @PrimaryKey(autoGenerate = true) val staffId: Int,
    @ColumnInfo(name = "name") val name: String
)