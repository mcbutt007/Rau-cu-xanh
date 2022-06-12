package com.nhom12.rau_cu_xanh.ui.about

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentAboutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nhom12.rau_cu_xanh.LoginActivity

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this)[AboutViewModel::class.java]

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // enable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.VISIBLE

        //Di chuyển đến
        binding.doiThongTin.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_thongTinCuaToiFragment))
        binding.baoMat.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_changePasswordFragment))
        binding.thongKe.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_chiTieuThangFragment))
        binding.donHang.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_donHangFragment))

        //Dang xuat
        binding.dangXuat.setOnClickListener {
            val sharedPref : SharedPreferences? =
                activity?.getSharedPreferences("LoginStatus", Context.MODE_PRIVATE)
            val editor = sharedPref?.edit()
            editor?.putInt("UserID", 0)
            editor?.putBoolean("RememberLogin", false)
            editor?.commit()

            val intent = Intent(this@AboutFragment.requireContext(), LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}