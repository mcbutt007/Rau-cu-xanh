package com.nhom12.rau_cu_xanh.network
// Địa chỉ server
private val BASE_URL =
    "http://192.168.1.46:5000/"
fun getBaseUrl(): String {
    return BASE_URL
}
private var userid : Int = 0
fun setUserid(value :Int) {
    userid = value
}
fun getUserid(): Int {
    return userid
}
private var selected_RauCu_ID : Int = 0
fun setSelected_RauCu_ID(value :Int) {
    selected_RauCu_ID = value
}
fun getSelected_RauCu_ID(): Int {
    return selected_RauCu_ID
}
