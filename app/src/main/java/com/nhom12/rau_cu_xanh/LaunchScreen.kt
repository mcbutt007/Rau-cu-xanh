package com.nhom12.rau_cu_xanh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Đây là màn hình splashscreen

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kiểm tra nếu giá trị RememberLogin là true hoặc false,
        // được set true khi đăng nhập và false khi đăng xuất lúc trước
        // nếu chưa có mặc định là false

        val sharedPref = getSharedPreferences("LoginStatus", MODE_PRIVATE)
        val rememberLogin = sharedPref.getBoolean("RememberLogin",false)

        if (!rememberLogin) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}