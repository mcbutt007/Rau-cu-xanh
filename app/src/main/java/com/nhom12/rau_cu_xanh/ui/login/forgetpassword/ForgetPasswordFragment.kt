package com.nhom12.rau_cu_xanh.ui.login.forgetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentForgetPasswordBinding
import com.nhom12.rau_cu_xanh.network.LoginApi
import kotlinx.android.synthetic.main.fragment_forget_password.*
import kotlinx.android.synthetic.main.return_to_title.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ForgetPasswordFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentForgetPasswordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_forget_password, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_forgetPasswordFragment_to_loginFragment))
        //Title text
        title_about_to?.setText(R.string.forget_password)
        //check email null or blank
        button_lay_lai_mk.setOnClickListener {
            if(!email_reset_password.text.isNullOrBlank()) {
                sendEmailToServer(email_reset_password.text.toString())
            } else {
                Toast.makeText(activity?.applicationContext, "Bạn chưa điền email của mình", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun sendEmailToServer(email: String) {
        GlobalScope .launch(Dispatchers.Main) {
            try {
                //send email to backend
                val serverResponse = LoginApi.retrofitService.sendEmailResetPassword(email)
                Toast.makeText(
                    activity?.applicationContext,
                    serverResponse,
                    Toast.LENGTH_SHORT
                )
                    .show()
                view?.let {
                    Navigation.findNavController(it)
                        .navigate(R.id.action_forgetPasswordFragment_to_FPSuccess)
                }

            } catch (e: Exception) {
                Toast.makeText(
                    activity?.applicationContext,
                    e.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}