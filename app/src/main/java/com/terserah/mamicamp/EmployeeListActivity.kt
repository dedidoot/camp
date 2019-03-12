package com.terserah.mamicamp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_employe_list.*

class EmployeeListActivity : AppCompatActivity() {

    var adapterBebas : EmployeeAdapter ?= null
    var datanya : MutableList<EmployeePojo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_employe_list)
        adapterBebas = EmployeeAdapter(this, datanya)
        recyclerEmployee.adapter = adapterBebas

        for (i in 0 until 100){
            datanya.add(
                EmployeePojo("Nama $i",
                "umur $i", "Salary $i")
            )
        }

        adapterBebas?.notifyDataSetChanged()

    }

}