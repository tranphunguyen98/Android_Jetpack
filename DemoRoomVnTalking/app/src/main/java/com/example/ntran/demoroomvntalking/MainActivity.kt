package com.example.ntran.demoroomvntalking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mDb: AppDatabase? = null

    fun saveData(v: View) {
        //Hàm xử lý click
        val employee = Employee()
        employee.name = etName.text.toString()
        employee.designation = etDesignation.text.toString()
        mDb?.employDao()?.insertEmploy(employee)
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show()
        etName.setText("")
        etDesignation.setText("")
        etName.requestFocus()
        populateEmployList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDb = AppDatabase.getAppDataBase(this)
        populateEmployList()
    }

    private fun populateEmployList() {
        txt_list.text = ""
        val employeeList = mDb?.employDao()?.findAllEmploySync()
        if (employeeList != null) {
            for (employee in employeeList) {
                txt_list.append(employee.name + " : " + employee.designation)
                txt_list.append("\n")
            }
        }
    }
}
