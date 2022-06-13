package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json
import java.text.DateFormat

data class Reciept (
    @Json(name = "RECIEPT_ID") var Reciept_ID : Int = 0,
    @Json(name = "USER_ID") var userID: Int = 0,
    @Json(name = "SHIPPING_COST") var Shipping_cost : Int = 0,
    @Json(name = "FINAL_PRICE") var Final_price : Int = 0,
    @Json(name = "SHIPPING_ADDR") var Shipping_addr : String = "",
    @Json(name = "CREATED_TIME") var Create_time : String = "",
)