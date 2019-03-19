package com.terserah.mamicamp.network

import android.util.Log
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import com.terserah.mamicamp.pojo.EmployeSenderPojo

object MamiCampUrl {

    private val KEY_BASE_URL = "http://dummy.restapiexample.com/api/v1/"
    private val KEY_GET_EMPLOYEE = "employees"
    private val KEY_SEND_EMPLOYEE = "create"

    fun sendEmployee(param: EmployeSenderPojo) {

        val urlSender = KEY_BASE_URL+KEY_SEND_EMPLOYEE
        val result: Response? = null
        urlSender.httpPost()
            .body(Gson().toJson(param))
            .responseString {
                request, response, result ->
                Log.i("MamiCampUrl", "Response $response")
                Log.i("MamiCampUrl", "Result $result")
            }
        //return result
    }

}