package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.ozady.carston.adapters.data.cars.CarSearchAdapter
import com.ozady.carston.adapters.data.cars.CarreraVariantsAdapter
import com.ozady.carston.databinding.ActivityChooseCarBinding
import com.ozady.carston.databinding.ActivitySelectDateTimeBinding
import com.ozady.carston.views.notifications.NotificationsListActivity
import java.util.*

class ChooseCarActivity : AppCompatActivity() {

    lateinit var binding: ActivityChooseCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChooseCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

/*
        binding.tabsCar.addTab(TabLayout.Tab().setText("All Cars"))
        binding.tabsCar.addTab(TabLayout.Tab().setText("Sedan"))
        binding.tabsCar.addTab(TabLayout.Tab().setText("Hatchback"))
        binding.tabsCar.addTab(TabLayout.Tab().setText("Sedan"))
        binding.tabsCar.addTab(TabLayout.Tab().setText("All Cars"))*/


        binding.carsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ChooseCarActivity)
            adapter = CarSearchAdapter(this@ChooseCarActivity)
        }

    }
}