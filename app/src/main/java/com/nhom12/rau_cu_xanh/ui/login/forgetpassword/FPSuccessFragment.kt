package com.nhom12.rau_cu_xanh.ui.login.forgetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentForgetPasswordSuccessBinding

class FPSuccessFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentForgetPasswordSuccessBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_forget_password_success, container, false)

        binding.buttonQuayLaiDn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_FPSuccess_to_loginFragment))

        return binding.root
    }
}