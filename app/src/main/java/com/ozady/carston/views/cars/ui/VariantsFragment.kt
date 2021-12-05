package com.ozady.carston.views.cars.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.CarreraVariantsAdapter
import com.ozady.carston.databinding.FragmentVariantsBinding

class VariantsFragment : Fragment() {

    private var _binding: FragmentVariantsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVariantsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.variantsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CarreraVariantsAdapter(context)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}