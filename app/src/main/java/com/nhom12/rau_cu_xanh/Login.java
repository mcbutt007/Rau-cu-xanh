package com.nhom12.rau_cu_xanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.window.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom12.rau_cu_xanh.R;

public class Login extends AppCompatActivity {
    Button switchToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        switchToSecondActivity = findViewById(R.id.button_dang_nhap);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}