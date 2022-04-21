package com.example.finaltest.ui.home.chitietsanpham

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaltest.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_chitietsanpham.*
import kotlinx.android.synthetic.main.return_to_about_title.*

class ChiTietSanPhamFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_chitietsanpham, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        danh_gia_san_pham.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_reviewFragment))
        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_navigation_home))

        cua_hang.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_storeFragment))
        //Title text
        title_about_to?.setText(R.string.title_chi_tiet_san_pham)
    }
}