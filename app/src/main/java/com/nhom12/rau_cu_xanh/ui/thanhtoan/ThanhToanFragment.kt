package com.nhom12.rau_cu_xanh.ui.thanhtoan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.nhom12.rau_cu_xanh.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nhom12.rau_cu_xanh.network.*
import kotlinx.android.synthetic.main.fragment_thanhtoan.*
import kotlinx.android.synthetic.main.return_to_title.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ThanhToanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //disable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        return inflater.inflate(R.layout.fragment_thanhtoan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        //back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.))
        //Title text
        title_about_to?.setText(R.string.title_thanh_toan)

        val sharedPref : SharedPreferences? =
            activity?.getSharedPreferences("LoginStatus", Context.MODE_PRIVATE)
        val userid = sharedPref?.getInt("UserID",0)

        dat_hang.setOnClickListener{
            MaterialAlertDialogBuilder(requireActivity())
                .setTitle("Đặt hàng")
                .setMessage("Bạn có muốn đặt hàng")

                .setNegativeButton("Hủy") { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Đồng ý") { dialog, which ->
                    GlobalScope.launch (Dispatchers.Main) {
                        if (userid != null) {
                            LoginApi.retrofitService.muahang(userid.toString(), getSelected_RauCu_ID().toString())
                        }
                    }
                    Navigation.findNavController(view).navigate(R.id.action_thanhToanFragment_to_chiTietHoaDonFragment)
                    Toast.makeText(activity,"Đặt hàng thành công!",Toast.LENGTH_LONG).show()
                }
                .show()
            }

        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_thanhToanFragment_to_chiTietSanPhamFragment))



        getProductFrom()
        }
    @OptIn(DelicateCoroutinesApi::class)
    private fun getProductFrom () {


        GlobalScope.launch(Dispatchers.Main) {
            try {

                val result = ProductApi.retrofitService.getProductInfo(getSelected_RauCu_ID().toString())

                tensp.text = result[0].Name
                giasp.text = result[0].Price.toString() + " VNĐ"
                giatien.text = result[0].Price.toString() + "Đ"
                val imageURL : String = getBaseUrl() + "raucu/" + result[0].RauCu_ID.toString() + ".png"
                Glide.with(requireActivity())
                    .load(imageURL) // image url
                    .centerCrop() // imageview Properties
                    .into(hinhsp);  // imageview object

            } catch (e: Exception) {
                Toast.makeText(activity, "Failure: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    }