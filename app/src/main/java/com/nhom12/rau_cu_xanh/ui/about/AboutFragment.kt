package com.nhom12.rau_cu_xanh.ui.about

import android.content.Intent
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
            ViewModelProvider(this).get(AboutViewModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // enable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.VISIBLE

        //val textView: TextView = binding.textAbout
        //aboutViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        // Đưa list view vào
        //val aboutList: ListView = binding.listSettingsAbout
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        //val arrHeading = resources.getStringArray(R.array.about_card_heading)
        //val arrSub = resources.getStringArray(R.array.about_card_sub)
        //3. Gán Data source vào ArrayAdapter
        //val adapter = ArrayAdapter.createFromResource(requireActivity(),R.array.about_card_heading,android.R.layout.two_line_list_item)
        //4. Đưa Data source vào ListView
        //aboutList.adapter = adapter

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
            val intent = Intent(this@AboutFragment.requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}