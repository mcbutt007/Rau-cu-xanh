package com.nhom12.rau_cu_xanh.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        binding.cardQuaOt.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_chiTietSanPhamFragment))

        binding.buttonKhuyenMai.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_khuyenMaiFragment))

        binding.buttonTraiCay.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_traiCayFragment))

        binding.giohang.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_cartFragment))

        // Swipe refresh : kéo xuống để cập nhật
        binding.swipeRefreshHome.setOnRefreshListener {
            Toast.makeText(activity?.applicationContext,"Đang cập nhật...", Toast.LENGTH_SHORT).show()
            // To keep animation for 4 seconds
            Handler().postDelayed(Runnable { // Stop animation (This will be after 3 seconds)
                swipe_refresh_home.isRefreshing = false
            }, 2000) // Delay in millis

        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}