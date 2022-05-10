package com.nhom12.rau_cu_xanh.model

// User để demo phần login
class User () {
    var userID = ""
    var username = ""
    var password = ""

    constructor(username : String, password : String) : this() {
        this.username = username
        this.password = password
    }
}