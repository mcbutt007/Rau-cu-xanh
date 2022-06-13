package com.nhom12.rau_cu_xanh.ui.home.chitietsanpham

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.network.ProductApi
import com.nhom12.rau_cu_xanh.network.getBaseUrl
import com.nhom12.rau_cu_xanh.network.getSelected_RauCu_ID
import com.nhom12.rau_cu_xanh.network.setSelected_RauCu_ID
import com.nhom12.rau_cu_xanh.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_chitietsanpham.*
import kotlinx.android.synthetic.main.fragment_chitietsanpham.gia
import kotlinx.android.synthetic.main.fragment_chitietsanpham.ten
import kotlinx.android.synthetic.main.product_item.*
import kotlinx.android.synthetic.main.return_to_title.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_navigation_home))

        mua_ngay.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_thanhToanFragment))

        cua_hang.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chiTietSanPhamFragment_to_storeFragment))
        //Title text
        title_about_to?.setText(R.string.title_chi_tiet_san_pham)

        //Set value
        getProductFrom()

    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun getProductFrom () {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val result = ProductApi.retrofitService.getProductInfo(getSelected_RauCu_ID().toString())

                ten.text = result[0].Name
                gia.text = result[0].Price.toString() + " VNĐ"
                description.text = result[0].Description
                val imageURL : String = getBaseUrl() + "raucu/" + result[0].RauCu_ID.toString() + ".png"
                Glide.with(requireActivity())
                    .load(imageURL) // image url
                    .centerCrop() // im
                    .into(hinhsanpham);  // imageview object

            } catch (e: Exception) {
                Toast.makeText(activity, "Failure: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}