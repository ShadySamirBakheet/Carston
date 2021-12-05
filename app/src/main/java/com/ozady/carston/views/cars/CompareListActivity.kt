package com.ozady.carston.views.cars

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.R
import com.ozady.carston.adapters.data.compare.CompareCarsViewAdapter
import com.ozady.carston.databinding.ActivityCompareListBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class CompareListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompareListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCompareListBinding.inflate(layoutInflater)
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
            adapter = CompareCarsViewAdapter(context)
        }

        binding.chooseBaseCar.apply {
            adapter = ArrayAdapter(context, R.layout.item_spinner, arrayOf("Car type 1","Car type 1","Car type 1","Car type 1","Car type 1","Car type 1",))
        }

    }
}