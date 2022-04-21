package com.example.finaltest.ui.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaltest.R
import kotlinx.android.synthetic.main.return_to_about_title.*

class ReviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back button setup
        back_to_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_reviewFragment_to_chiTietSanPhamFragment))
        //Title text
        title_about_to?.setText(R.string.title_review)
    }
}