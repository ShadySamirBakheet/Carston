package com.ozady.carston.views.cars.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.GalleryImageAdapter
import com.ozady.carston.adapters.data.videos.VideosCarAdapter
import com.ozady.carston.databinding.FragmentGalleryBinding
import com.ozady.carston.views.videos.VideosActivity

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.picturesList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,3)
            adapter = GalleryImageAdapter(context)
        }

        binding.videoList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = VideosCarAdapter(context)
        }

        binding.videosCon.setOnClickListener {
            startActivity(Intent(context,VideosActivity::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}