package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Shop(
    @Json(name = "SHOP_ID") var Shop_ID: Int = 0,
    @Json(name = "NAME") var Shop_name: String = "",
    @Json(name = "ADDRESS") var Shop_addr : String = "",
    @Json(name = "PHONE_NO") var Shop_phone : String = "",
    @Json(name = "TIME_CREATED") var Time_create: String = "",
    @Json(name = "NO_SELLING_PRODUCTS") var No_selling_product: Int = 0,
    @Json(name = "REVIEW_ID") var Review_ID : Int = 0,
    @Json(name = "NO_PRODUCTS_SOLD") var No_product_sold : String = "")