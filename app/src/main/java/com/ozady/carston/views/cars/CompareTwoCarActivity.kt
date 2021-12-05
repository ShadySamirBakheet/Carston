package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.R
import com.ozady.carston.adapters.data.cars.FeaturesAdapters
import com.ozady.carston.adapters.data.cars.SpecificationsAdapter
import com.ozady.carston.adapters.slider.SliderCarAdapter
import com.ozady.carston.databinding.ActivityCompareTwoCarBinding
import com.ozady.carston.views.seller.SellerViewActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class CompareTwoCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompareTwoCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCompareTwoCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chooseBaseCar1.apply {
            adapter = ArrayAdapter(context, R.layout.item_spinner, arrayOf("Car Name 1","Car Name 1","Car Name 1","Car Name 1","Car Name 1","Car Name 1",))
        }

        binding.chooseBaseCar2.apply {
            adapter = ArrayAdapter(context, R.layout.item_spinner, arrayOf("Car Name 1","Car Name 1","Car Name 1","Car Name 1","Car Name 1","Car Name 1",))
        }

        binding.specificationsList1.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = SpecificationsAdapter(context)
        }

        binding.btnSeller1.setOnClickListener {
            startActivity(Intent(this, SellerViewActivity::class.java))
        }

        binding.featuresList1.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = FeaturesAdapters(context)
        }

        binding.imageSlider1.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderCarAdapter(context))
        }

        binding.specificationsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = SpecificationsAdapter(context)
        }

        binding.btnSeller.setOnClickListener {
            startActivity(Intent(this, SellerViewActivity::class.java))
        }

        binding.featuresList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = FeaturesAdapters(context)
        }

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderCarAdapter(context))
        }

    }
}