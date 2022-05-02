package com.nhom12.rau_cu_xanh.ui.login.createnewaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentCreateNewAccountBinding
import kotlinx.android.synthetic.main.fragment_create_new_account.*
import kotlinx.android.synthetic.main.return_to_title.*

class CreateNewAccountFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentCreateNewAccountBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_new_account, container, false)

        binding.buttonTaoTkMoi.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_createNewAccountFragment_to_createNewAccountSuccessFragment))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_createNewAccountFragment_to_loginFragment))
        //Title text
        title_about_to?.setText(R.string.title_tao_tk_moi)
    }
}