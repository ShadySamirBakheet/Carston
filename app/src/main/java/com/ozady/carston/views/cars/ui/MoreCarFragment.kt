package com.ozady.carston.views.cars.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozady.carston.R
import com.ozady.carston.databinding.FragmentMoreBinding
import com.ozady.carston.databinding.FragmentMoreCarBinding
import com.ozady.carston.databinding.FragmentSpecsFeaturesBinding

class MoreCarFragment : Fragment() {

    private var _binding: FragmentMoreCarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoreCarBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}