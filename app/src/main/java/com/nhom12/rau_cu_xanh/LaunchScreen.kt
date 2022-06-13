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
        val userid = sharedPref.getInt("UserID",0)
        Toast.makeText(this,userid.toString(),Toast.LENGTH_SHORT).show()
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