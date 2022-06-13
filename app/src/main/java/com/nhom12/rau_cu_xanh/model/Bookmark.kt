package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Bookmark(
    @Json(name = "BOOKMARK_ID") var Bookmark_ID: Int = 0,
    @Json(name = "USER_ID") var userID: Int = 0,
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "TIME_STAMP") var Time_stamp : String = ""
)