package com.nhom12.rau_cu_xanh.ui.chitiethoadon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_chitietsanpham.*
import kotlinx.android.synthetic.main.return_to_title.*

class ChiTietHoaDonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //disable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        return inflater.inflate(R.layout.fragment_chitiethoadon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietHoaDonFragment_to_donHangFragment))
        //Title text
        title_about_to?.setText(R.string.title_chi_tiet_hoa_don)
    }
}