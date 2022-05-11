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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleService
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.MainActivity
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentLoginBinding
import com.nhom12.rau_cu_xanh.model.User
import com.nhom12.rau_cu_xanh.network.LoginApi
import com.nhom12.rau_cu_xanh.network.LoginApiService
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.quenMatKhau.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_forgetPasswordFragment)
        )

        binding.taoTaiKhoanMoi.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_createNewAccountFragment)
        )

        binding.buttonDangNhap.setOnClickListener() {
            //Bypass login
            //switchToMainActivities()

            login()
        }

        return binding.root
    }

    //send username && password to server
    @OptIn(DelicateCoroutinesApi::class)
    fun login() {
        val user = User(username.text.toString(), password.text.toString())
        GlobalScope .launch(Dispatchers.Main) {
            try {
                //server return corresponding user id
                val id = LoginApi.retrofitService.sendLoginInfo(user.username,user.password)
                // if id check
                if (id >0) {
                    switchToMainActivities()
                } else { //id = 0 : User not found in database
                    Toast.makeText(
                        activity?.applicationContext,
                        "Sai tài khoản hoặc mật khẩu",
                        Toast.LENGTH_LONG
                    ).show()
                }


            } catch (e : Exception) {
                Toast.makeText(
                    activity?.applicationContext,
                    e.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    private fun switchToMainActivities() {
        val switchActivityIntent = Intent(context, MainActivity::class.java)
        startActivity(switchActivityIntent)
    }
}