package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Review(
    @Json(name = "REVIEW_ID") var Review_ID: Int = 0,
    @Json(name = "USER_ID") var userID: Int = 0,
    @Json(name = "STARS") var Star: Int = 0,
    @Json(name = "COMMENTS") var Comments: String = "",
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "SHOP_ID") var Shop_ID : Int = 0,
    @Json(name = "TIME_STAMP") var Time_stamp : String = ""

    )