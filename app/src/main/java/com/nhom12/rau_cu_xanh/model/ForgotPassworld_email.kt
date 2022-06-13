package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class ForgotPassworld_email(
    @Json(name = "EMAIL") var email_recovery : String = "",
    @Json(name = "TIME_STAMP") var Time_stamp : String = "")