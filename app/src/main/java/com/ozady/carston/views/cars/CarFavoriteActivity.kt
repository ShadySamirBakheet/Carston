package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.search.SearchAdapter
import com.ozady.carston.databinding.ActivityCarFavoriteBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class CarFavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.searchList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CarFavoriteActivity)
            adapter = SearchAdapter(this@CarFavoriteActivity,true)
        }


    }
}