package com.terserah.mamicamp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.layout_employe_list.*

class EmployeeListActivity : AppCompatActivity() {

    var adapterBebas: EmployeeAdapter? = null
    var datanya: MutableList<EmployeePojo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_employe_list)
        adapterBebas = EmployeeAdapter(this, datanya)
        recyclerEmployee.adapter = adapterBebas

        for (i in 0 until 100) {
            datanya.add(
                EmployeePojo(
                    "Nama $i",
                    "umur $i", "Salary $i"
                )
            )
        }

        adapterBebas?.notifyDataSetChanged()

        getData()

    }

    private fun getData() {
        val baseUrlGet = "http://dummy.restapiexample.com/api/v1/employees"
        baseUrlGet
            .httpGet()
            .responseString { request, response, result ->

                val listType = object : TypeToken<ArrayList<EmployeePojo>>() {
                }.type

                datanya = Gson().fromJson(result.component1(), listType)

                Log.e("response", "${datanya.size}")
                Log.e("response", "${datanya[0].employeeName}")
            }
    }

}