package com.nhom12.rau_cu_xanh.ui.about.thong_tin_cua_toi

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.datepicker.MaterialDatePicker
import com.nhom12.rau_cu_xanh.MainActivity
import com.nhom12.rau_cu_xanh.R
import kotlinx.android.synthetic.main.fragment_create_new_account_success.*
import kotlinx.android.synthetic.main.fragment_thong_tin_cua_toi.*
import kotlinx.android.synthetic.main.return_to_title.*
import java.io.FileNotFoundException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class ThongTinCuaToiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //disable bottom nav bar
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        return inflater.inflate(R.layout.fragment_thong_tin_cua_toi, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_thongTinCuaToiFragment_to_navigation_about))
        //Title text
        title_about_to?.setText(R.string.title_thong_tin_ca_nhan)

        // Date picker implementation
        date_picker_button.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            datePicker.show(fragmentManager, "DatePicker")

            // Setting up the event for when ok is clicked
            datePicker.addOnPositiveButtonClickListener {
                // formatting date in dd-mm-yyyy format.
                val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
                val date = dateFormatter.format(Date(it))
                date_selected.text = date.toString()
            }
            // Setting up the event for when cancelled is clicked
            datePicker.addOnNegativeButtonClickListener {
                Toast.makeText(
                    activity?.applicationContext,
                    "${datePicker.headerText} is cancelled",
                    Toast.LENGTH_LONG
                ).show()
            }

            // Setting up the event for when back button is pressed
            datePicker.addOnCancelListener {
                Toast.makeText(
                    activity?.applicationContext,
                    "Date Picker Cancelled",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        //Setup chon gioi tinh
        val items = listOf("Hảo hán", "Nam", "Nữ")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_gioi_tinh, items)
        gioi_tinh.setAdapter(adapter)

        button_cap_nhat.setOnClickListener {
            Toast.makeText(activity?.applicationContext, "Cập nhật thành công", Toast.LENGTH_LONG)
                .show()
        }
        // change profile picture
        profile_picture.setOnClickListener{
            openGalleryForImage()
        }
    }
    // image chooser

    val REQUEST_CODE = 100
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            profile_picture.setImageURI(data?.data) // handle chosen image
        }
    }
    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }
}