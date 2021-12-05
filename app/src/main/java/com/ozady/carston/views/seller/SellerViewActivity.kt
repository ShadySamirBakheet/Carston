package com.ozady.carston.views.seller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.compare.ExpertReviewsViewAdapter
import com.ozady.carston.databinding.ActivitySellerViewBinding
import com.ozady.carston.databinding.ActivityVideosBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class SellerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivitySellerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySellerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.userCarsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ExpertReviewsViewAdapter(context)
        }

    }
}