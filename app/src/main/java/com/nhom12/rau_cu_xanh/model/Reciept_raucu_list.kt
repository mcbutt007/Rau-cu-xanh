package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Reciept_raucu_list(
    @Json(name = "RECIEPT_ID") var Reciept_ID : Int = 0,
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "QUANTITY ") var Quantity: Int = 0
)