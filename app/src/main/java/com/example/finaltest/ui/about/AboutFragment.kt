package com.example.finaltest.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.finaltest.R
import com.example.finaltest.databinding.FragmentAboutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        binding.doiThongTin.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_thongTinCuaToiFragment))
        binding.baoMat.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_navigation_about_to_changePasswordFragment))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}