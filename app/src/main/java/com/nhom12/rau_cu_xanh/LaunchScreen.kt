package com.nhom12.rau_cu_xanh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("LoginStatus", MODE_PRIVATE)
        val rememberLogin = sharedPref.getBoolean("RememberLogin",false)
        val userid = sharedPref.getString("UserID","0")
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