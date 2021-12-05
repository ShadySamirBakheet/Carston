package com.ozady.carston.views.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.home.BrandAdapter
import com.ozady.carston.adapters.data.home.OfferAdapter
import com.ozady.carston.databinding.FragmentOffersBinding

class OffersFragment : Fragment() {

    private var _binding: FragmentOffersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOffersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.brandList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = BrandAdapter(context,false)
        }

        binding.offersList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = OfferAdapter(context)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}