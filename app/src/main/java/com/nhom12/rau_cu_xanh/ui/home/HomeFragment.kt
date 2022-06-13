package com.nhom12.rau_cu_xanh.ui.home

import android.os.Bundle
import android.os.Handler
import android.provider.SyncStateContract
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
import com.nhom12.rau_cu_xanh.helper.RecyclerItemClickListenr
import com.nhom12.rau_cu_xanh.network.getSelected_RauCu_ID
import com.nhom12.rau_cu_xanh.network.setSelected_RauCu_ID
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Đổ dữ liệu vào recyclerview
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
            //Code để cập nhật sau khi pull to refresh ở dưới đây:

            //update recyclerview cái GlobalScope tạm thời không quan tâm, chỉ quan tâm đến FillRecyclerView
            GlobalScope.launch (Dispatchers.Main) { FillRecyclerView() }
        }
        return root
    }

    private suspend fun FillRecyclerView() {
        val productList = Datasource().getProductList()

        // Chia thành 2 cột
        recyclerviewHome.layoutManager = GridLayoutManager(context, 2)
        // cho vào adapter
        recyclerviewHome.adapter = ProductAdapter(productList)
        // Khi click vào 1 item, chỉ quan tâm đến hàm onItemClick
        recyclerviewHome.addOnItemTouchListener(RecyclerItemClickListenr(requireActivity(), recyclerviewHome, object : RecyclerItemClickListenr.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                view.card.setOnClickListener {
                    setSelected_RauCu_ID(position+1)
                    Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_chiTietSanPhamFragment)
                }
            }

            override fun onItemLongClick(view: View?, position: Int) {
                view?.card?.setOnClickListener {
                    setSelected_RauCu_ID(position+1)
                    Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_chiTietSanPhamFragment)
                }
            }
        }))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}