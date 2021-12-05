package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.compare.ExpertReviewsViewAdapter
import com.ozady.carston.databinding.ActivityExpertReviewsListBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class ExpertReviewsListActivity : AppCompatActivity() {

    lateinit var binding: ActivityExpertReviewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpertReviewsListBinding.inflate(layoutInflater)
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
            adapter = ExpertReviewsViewAdapter(context)
        }

    }
}