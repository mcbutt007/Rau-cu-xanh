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
import androidx.recyclerview.widget.GridLayoutManager
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.adapter.ProductAdapter
import com.nhom12.rau_cu_xanh.databinding.FragmentHomeBinding
import com.nhom12.rau_cu_xanh.datasource.Datasource
import com.nhom12.rau_cu_xanh.helper.onItemClick
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.product_item.view.*
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

        GlobalScope.launch (Dispatchers.Main) { FillRecyclerView() }

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
            //update recyclerview
            GlobalScope.launch (Dispatchers.Main) { FillRecyclerView() }
        }
        return root
    }

    suspend fun FillRecyclerView() {
        val productList = Datasource().getProductList()

        // Chia thành 2 cột
        recyclerviewHome.layoutManager = GridLayoutManager(context, 2)
        // cho vào adapter
        recyclerviewHome.adapter = ProductAdapter(productList)
        // Khi click vào 1 item
        recyclerviewHome.onItemClick { recyclerView, position, v ->
            v.card_layout.setOnClickListener{
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                selected_RauCu_ID = position + 1
                view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_navigation_home_to_chiTietSanPhamFragment) }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}