package com.nhom12.rau_cu_xanh.ui.about.change_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.return_to_title.*

class ChangePasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //disable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_changePasswordFragment_to_navigation_about))
        //Title text
        title_about_to?.setText(R.string.title_change_password)
    }
}