package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Shop_raucu_list(
    @Json(name = "SHOP_ID") var Shop_ID: Int = 0,
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "QUANTITY") var Quantity: Int = 0
)