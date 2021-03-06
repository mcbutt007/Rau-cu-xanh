package com.nhom12.rau_cu_xanh.ui.login

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
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
import com.nhom12.rau_cu_xanh.model.User
import com.nhom12.rau_cu_xanh.network.LoginApi
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    private var userid : Int = 0
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
            login()
        }
        return binding.root
    }

    //send username && password to server
    @OptIn(DelicateCoroutinesApi::class)
    fun login() {

        if (username.text.isNullOrBlank() && password.text.isNullOrBlank()) {
            Toast.makeText(context,"Bạn chưa điền tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show()
            return
        }

        val user = User(username.text.toString(), password.text.toString())
        GlobalScope .launch(Dispatchers.Main) {
            try {
                //server sẽ trả về id người dùng, nếu = 0 thì sai tk hoặc mk
                userid = LoginApi.retrofitService.sendLoginInfo(user.username,user.password)
                // if id check
                if (userid >0) {

                    // SharedPreferences để lưu userid sau khi đăng nhập và trạng thái tự động đăng nhập (RememberLogin)
                    val sharedPref : SharedPreferences =
                        activity?.getSharedPreferences("LoginStatus", MODE_PRIVATE) ?: return@launch
                    val editor = sharedPref.edit()
                        editor.putInt("UserID", userid)
                        editor.putBoolean("RememberLogin", true)
                        editor.commit()

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
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("USER_ID", userid)
        startActivity(intent)
        activity?.finish()
    }
}