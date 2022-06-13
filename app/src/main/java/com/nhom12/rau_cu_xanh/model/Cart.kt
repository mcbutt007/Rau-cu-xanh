package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Cart(
    @Json(name = "CART_ID") var Cart_ID : Int = 0,
    @Json(name = "USER_ID") var userID: Int = 0,
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "QUANTITY ") var Quantity: Int = 0,
    @Json(name = "TIME_STAMP") var Time_stamp : String = ""
)