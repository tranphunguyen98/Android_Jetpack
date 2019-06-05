package com.example.ntran.demoroomvntalking

import android.arch.persistence.room.Update
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface EmployDao {
    @Insert(onConflict = REPLACE)
    fun insertEmploy(employee: Employee)

    @Insert(onConflict = IGNORE)
    fun insertOrReplaceEmploy(vararg employees: Employee)

    @Update(onConflict = REPLACE)
    fun updateEmploy(employee: Employee)

    @Query("DELETE FROM Employee")
    fun deleteAll()

    @Query("SELECT * FROM Employee")
    fun findAllEmploySync(): List<Employee>
}