package com.nhom12.rau_cu_xanh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.nhom12.rau_cu_xanh.LoginActivity

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}