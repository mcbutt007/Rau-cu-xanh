package com.nhom12.rau_cu_xanh.ui.login.createnewaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentCreateNewAccountSuccessBinding

class CreateNewAccountSuccessFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentCreateNewAccountSuccessBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_new_account_success, container, false)

        binding.buttonQuayLaiDn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_createNewAccountSuccessFragment_to_loginFragment))

        return binding.root
    }
}