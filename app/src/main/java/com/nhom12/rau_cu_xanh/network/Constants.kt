package com.nhom12.rau_cu_xanh.network
// Địa chỉ server
private val BASE_URL =
    "http://104.154.113.165:5000/"
fun getBaseUrl(): String {
    return BASE_URL
}
private var selected_RauCu_ID : Int = 0
fun setSelected_RauCu_ID(value :Int) {
    selected_RauCu_ID = value
}
fun getSelected_RauCu_ID(): Int {
    return selected_RauCu_ID
}
