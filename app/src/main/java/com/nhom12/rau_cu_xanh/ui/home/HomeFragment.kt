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
import com.bumptech.glide.Glide
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.databinding.FragmentHomeBinding
import com.nhom12.rau_cu_xanh.network.ProductApi
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    var selected_RauCu_ID : Int = 0
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
        getProductFrom()
        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        binding.hinhQuaOt.setOnClickListener() {
            selected_RauCu_ID = 1
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_chiTietSanPhamFragment)
        }

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
            getProductFrom()
        }
        return root
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun getProductFrom () {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val listResult = ProductApi.retrofitService.getProduct()
                Toast.makeText(
                    activity,
                    "Success: ${listResult.size} Mars photos retrieved",
                    Toast.LENGTH_SHORT
                ).show()
                tenQuaOt.setText(listResult[1].Name)
                giaQuaOt.setText(listResult[1].Price.toString() + " VNĐ")
            } catch (e: Exception) {
                Toast.makeText(activity, "Failure: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
                .load("http://192.168.1.218:5000/raucu/0.png") // image url
                .centerCrop()
                .into(test.hinhQuaOt);  // imageview object
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}