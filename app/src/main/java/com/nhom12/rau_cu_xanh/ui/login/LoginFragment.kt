package com.nhom12.rau_cu_xanh.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.MainActivity
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private var user: User? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        user = User()
        getList()

        binding.quenMatKhau.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_forgetPasswordFragment)
        )

        binding.taoTaiKhoanMoi.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_createNewAccountFragment)
        )

        binding.buttonDangNhap.setOnClickListener() {


            //Import username & password
            val struser: String = binding.username.text.toString().trim()
            val strpass: String = binding.password.text.toString().trim()
            val struser1 = user!!.page.toString()
            val strpass1 = user!!.per_page.toString()

            Log.i("MyDebug", "Username : $struser")
            Log.i("MyDebug", "Username1 : $struser1")
            Log.i("MyDebug", "Passwd : $strpass")
            Log.i("MyDebug", "Passwd1 : $strpass1")

            //Username = 0 Password = 0
            //check
            val check = struser == struser1 && strpass == strpass1

            if (check) {
                Toast.makeText(activity?.applicationContext,"Đăng nhập thành công",Toast.LENGTH_SHORT).show()
                switchActivities()
            } else {
                Toast.makeText(activity?.applicationContext,"Mật khẩu hoặc tài khoản không đúng",Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun getList() {
        AppService.apiService.getlist("1").enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                user = response.body()
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Toast.makeText(activity?.applicationContext,"Kết nối thất bại, xem lại internet của bạn",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun switchActivities() {
        val switchActivityIntent = Intent(context, MainActivity::class.java)
        startActivity(switchActivityIntent)
    }
}