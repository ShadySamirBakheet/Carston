package com.ozady.carston.views.videos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.compare.ExpertReviewsViewAdapter
import com.ozady.carston.adapters.data.videos.VideosViewAdapter
import com.ozady.carston.databinding.ActivityExpertReviewsListBinding
import com.ozady.carston.databinding.ActivityVideosBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class VideosActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideosBinding.inflate(layoutInflater)
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
            adapter = VideosViewAdapter(context)
        }

    }
}