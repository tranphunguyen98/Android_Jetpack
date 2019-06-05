package com.example.ntran.demoroomvntalking

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Employee {
    @PrimaryKey(autoGenerate = true)
    var employId: Long = 0
    @ColumnInfo(name = "employ_name")
    var name: String? = null
    var designation: String? = null
}