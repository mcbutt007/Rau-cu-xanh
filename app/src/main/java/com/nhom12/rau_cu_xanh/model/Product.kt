package com.nhom12.rau_cu_xanh.model

import com.squareup.moshi.Json

data class Product(
    @Json(name = "RAUCU_ID") var RauCu_ID : Int = 0,
    @Json(name = "NAME") var Name: String = "",
    @Json(name = "TYPE") var Type : String = "",
    @Json(name = "SHOP_ID") var Shop_ID : Int = 0,
    @Json(name = "PRICE") var Price : Int = 0,
    @Json(name = "DESCRIPTION") var Description: String = "",
    @Json(name = "REVIEW_ID") var Review_ID : Int = 0,
    @Json(name = "TIME_CREATED") var Time_created: String = "",
    @Json(name = "DISCOUNT") var Discount : Float = 0F,
    @Json(name = "ITEMSOLD") var ItemSold : Int = 0,
)
/*
Parse json tư server, VD
{
    "DESCRIPTION": "Ớt là một loại quả của các cây thuộc chi Capsicum của họ Cà.",
    "DISCOUNT": 0,
    "ITEMSOLD": 20,
    "NAME": "Ớt ",
    "PRICE": 5000,
    "RAUCU_ID": 2,
    "REVIEW_ID": 0,
    "SHOP_ID": 1,
    "TIME_CREATED": "2022-06-08 17:27:11",
    "TYPE": "rau"
}*/
