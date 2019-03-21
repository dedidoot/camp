package com.terserah.mamicamp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bugsnag.android.Bugsnag
import com.terserah.mamicamp.network.MamiCampUrl
import com.terserah.mamicamp.pojo.EmployeSenderPojo
import kotlinx.android.synthetic.main.layout_form.*
import timber.log.Timber

/*
* 1. Buat Pojo Employee
* 2. Buat Adapter Employee
* 3. Buat Activity Employee RecyclerView dan buat button utk mengarahkan ke list
* 4. Setup data dummy Activity Employee
* 5. Import Fuel Rest Client
* 6. Permission (internet)
* */

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_form)

        LihatDataButton.setOnClickListener {
            val intent = Intent(FormActivity@this, EmployeeListActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {

        mainProgressBar.visibility = View.VISIBLE

        val name = editText.text.toString()
        val salary = editText3.text.toString()
        val age = umurEdittext.text.toString()

        var checkA = "Length"

        if (name.length < 3) {
            Toast.makeText(this, "Nama Anda terlalu singkat", Toast.LENGTH_SHORT).show()
            dismissLoading()
        } else {
            val employePojo = EmployeSenderPojo(name, salary, age)
            Timber.d("Send Pojo $employePojo")

            MamiCampUrl.sendEmployee(employePojo)?.let {
                Log.i("FormActivity", "Response are $it")
            }
            dismissLoading()
        }

        try {
            checkA.get(100)
        } catch (exception: Throwable) {
            Bugsnag.notify(exception)
        }

    }

    private fun dismissLoading() {
        mainProgressBar.postDelayed({
                mainProgressBar.visibility = View.GONE
            }, 2000)
    }
}