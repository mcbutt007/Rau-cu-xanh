package com.nhom12.rau_cu_xanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.nhom12.rau_cu_xanh.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private User user;
    Button switchToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tv1 = findViewById(R.id.username);
        tv2 = findViewById(R.id.password);
        user = new User();
        getlist();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        switchToSecondActivity = findViewById(R.id.button_dang_nhap);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklogin();
            }
        });

    }

    private void clicklogin() {
        String struser = tv1.getText().toString().trim();
        String strpass = tv2.getText().toString().trim();
        String struser1 = String.valueOf(user.getPage());
        String strpass1 = String.valueOf(user.getPer_page());

        boolean check = struser.equals(struser1) && strpass.equals(strpass1);

        if (check) {
            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            switchActivities();
        } else {
            Toast.makeText(Login.this, "Mật khẩu hoặc tài khoản không đúng", Toast.LENGTH_SHORT).show();
        }

    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    private void getlist() {
        AppService.apiService.getlist("1").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(Login.this, "TC", Toast.LENGTH_SHORT).show();
                user = response.body();
                //tv3.setText(String.valueOf(user.getPage()));
                };

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Login.this, "Thất bại", Toast.LENGTH_SHORT).show();
                };
        });
    }
}