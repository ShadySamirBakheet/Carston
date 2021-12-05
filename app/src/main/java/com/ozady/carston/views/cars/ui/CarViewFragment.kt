package com.ozady.carston.views.cars.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.FeaturesAdapters
import com.ozady.carston.adapters.data.cars.SpecificationsAdapter
import com.ozady.carston.adapters.data.home.PopularCarAdapter
import com.ozady.carston.adapters.slider.SliderCarAdapter
import com.ozady.carston.databinding.FragmentCarViewBinding
import com.ozady.carston.views.seller.SellerViewActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class CarViewFragment : Fragment() {

    private var _binding: FragmentCarViewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCarViewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.specificationsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = SpecificationsAdapter(context)
        }

        binding.btnSeller.setOnClickListener {
            startActivity(Intent(context, SellerViewActivity::class.java))
        }

        binding.btnCall.setOnClickListener {
            callNumber("+201207090513")
        }

        binding.featuresList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = FeaturesAdapters(context)
        }

        binding.compareList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = PopularCarAdapter(context)
        }

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderCarAdapter(context))
        }

        return root
    }


    private fun callNumber(phone:String) {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CALL_PHONE),
                1
            )
        }else{
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:" +phone)
            startActivity(callIntent)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}