package com.terserah.mamicamp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EmployeePojo(
    @SerializedName("employee_name") var employeeName: String? = null,
    var employeeAge: String? = null,
    var employeeSalary: String? = null
) : Parcelable