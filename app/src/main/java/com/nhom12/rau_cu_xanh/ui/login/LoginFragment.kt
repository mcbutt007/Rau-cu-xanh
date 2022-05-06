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
import androidx.navigation.findNavController
import com.nhom12.rau_cu_xanh.MainActivity
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.api.login.login_Api.Companion.ApiService
import com.nhom12.rau_cu_xanh.databinding.FragmentLoginBinding
import com.nhom12.rau_cu_xanh.model.User
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            switchToMainActivities()

            check_User_Login()
        }

        return binding.root
    }

    private fun getMyData() {
        ApiService.getUser(4).enqueue(object : Callback<Array<User>> {
            override fun onResponse(call: Call<Array<User>>, response: Response<Array<User>>) {
                Log.e("Test response", response.body().toString())
                Toast.makeText(activity,"Yeah!!",Toast.LENGTH_SHORT).show()
                val books: Array<User>? = response.body()
                if (books != null) {
                    val book: User = books[0]
                    username.setText(book.full_name)
                    password.setText(book.password)
                }
            }

            override fun onFailure(call: Call<Array<User>>, t: Throwable) {
                Toast.makeText(activity, "Failed!! " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun check_User_Login() {

        val str: String = username.text.toString()
        ApiService.getUser_via_UserName(str).enqueue(object : Callback<Array<User>> {
            override fun onResponse(call: Call<Array<User>>, response: Response<Array<User>>) {
                Log.e("Test response", response.body().toString())
                val books: Array<User>? = response.body()
                if (books != null) {
                    val book: User = books[0]
                    if(book.password == password.text.toString())
                        switchToMainActivities()
                    else
                        Toast.makeText(activity, "Password not Correct!!",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "User not fond!!",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Array<User>>, t: Throwable) {
                Toast.makeText(activity, "Failed!! " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun switchToMainActivities() {
        val switchActivityIntent = Intent(context, MainActivity::class.java)
        startActivity(switchActivityIntent)
    }
}