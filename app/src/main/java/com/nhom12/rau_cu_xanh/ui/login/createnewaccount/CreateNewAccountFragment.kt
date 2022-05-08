package com.nhom12.rau_cu_xanh.ui.login.createnewaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentCreateNewAccountBinding
import com.nhom12.rau_cu_xanh.network.LoginApi
import kotlinx.android.synthetic.main.fragment_create_new_account.*
import kotlinx.android.synthetic.main.return_to_title.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateNewAccountFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentCreateNewAccountBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_new_account, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_createNewAccountFragment_to_loginFragment))
        //Title text
        title_about_to?.setText(R.string.title_tao_tk_moi)
        //Check edit text view is null or not
        button_tao_tk_moi.setOnClickListener{
            if (!username.text.isNullOrBlank() && !user_email.text.isNullOrBlank() && !user_password.text.isNullOrBlank() && terms_and_conditions_check.isChecked) {
                sendRegistrationInfoToServer(username.text.toString(), user_email.text.toString(), user_password.text.toString())
            } else if (!terms_and_conditions_check.isChecked) {
                Toast.makeText(activity?.applicationContext, "Bạn chưa đồng ý với điều khoản", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(activity?.applicationContext, "Bạn chưa điền đầy đủ thông tin", Toast.LENGTH_SHORT)
                    .show()
            }

        }

    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun sendRegistrationInfoToServer(username: String, email: String, password: String) {
        GlobalScope .launch(Dispatchers.Main) {
            try {
                //send user info to backend
                val serverResponse = LoginApi.retrofitService.sendRegistrationInfo(username, email, password)

                Toast.makeText(activity?.applicationContext, serverResponse, Toast.LENGTH_SHORT)
                    .show()
                view?.let { Navigation.findNavController(it).navigate(R.id.action_createNewAccountFragment_to_createNewAccountSuccessFragment) }

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