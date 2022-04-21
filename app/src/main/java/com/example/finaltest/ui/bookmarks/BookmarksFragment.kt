package com.example.finaltest.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finaltest.R
import com.example.finaltest.databinding.FragmentBookmarksBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BookmarksFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this).get(BookmarksViewModel::class.java)

        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textBookmarks
        //aboutViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.VISIBLE

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}