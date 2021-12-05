package com.ozady.carston.views.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.home.BodyCarAdapter
import com.ozady.carston.adapters.data.search.FilterColorAdapter
import com.ozady.carston.adapters.data.search.FilterPriceAdapter
import com.ozady.carston.adapters.data.search.FilterResultAdapter
import com.ozady.carston.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.filterList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FilterActivity, LinearLayoutManager.HORIZONTAL,false)
            adapter = FilterResultAdapter(this@FilterActivity)
        }

        binding.filterPriceList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FilterActivity)
            adapter = FilterPriceAdapter(this@FilterActivity)
        }

        binding.filterBrandList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@FilterActivity,2)
            adapter = FilterPriceAdapter(this@FilterActivity)
        }


        binding.filterTransmissionList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FilterActivity)
            adapter = FilterPriceAdapter(this@FilterActivity)
        }


        binding.filterFuelList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FilterActivity)
            adapter = FilterPriceAdapter(this@FilterActivity)
        }

        binding.filterTransmissionList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FilterActivity)
            adapter = FilterPriceAdapter(this@FilterActivity)
        }

        binding.filterVehicleList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,3)
            adapter = BodyCarAdapter(context, true, true)
        }

        binding.filterColorList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,4)
            adapter = FilterColorAdapter(context)
        }

    }
}