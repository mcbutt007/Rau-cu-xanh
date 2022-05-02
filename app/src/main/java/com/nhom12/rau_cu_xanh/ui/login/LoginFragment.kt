package com.nhom12.rau_cu_xanh.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.MainActivity
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentLoginBinding

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
            switchActivities()
        }

        return binding.root
    }

    private fun switchActivities() {
        val switchActivityIntent = Intent(context, MainActivity::class.java)
        startActivity(switchActivityIntent)
    }
}
