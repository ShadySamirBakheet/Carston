package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.NewCarAdapter
import com.ozady.carston.adapters.data.home.PopularCarAdapter
import com.ozady.carston.databinding.ActivityChooseCarBinding
import com.ozady.carston.databinding.ActivityNewCarsBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class NewCarsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewCarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.newCarList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NewCarAdapter(context)
        }

    }
}