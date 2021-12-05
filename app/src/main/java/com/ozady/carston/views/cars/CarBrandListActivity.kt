package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.NewCarAdapter
import com.ozady.carston.databinding.ActivityCarBrandListBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class CarBrandListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarBrandListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarBrandListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.carsCompareList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NewCarAdapter(context)
        }

    }
}