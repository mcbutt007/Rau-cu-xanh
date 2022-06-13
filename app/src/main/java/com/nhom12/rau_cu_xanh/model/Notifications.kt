package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Notifications(
    @Json(name = "NOTI_ID") var Noti_ID : Int = 0,
    @Json(name = "USER_ID") var userID: Int = 0,
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "TYPE") var Type : String = "",
    @Json(name = "DESCRIPTION") var Description : String = "",
    @Json(name = "TIME_STAMP") var Time_stamp : String = ""
)