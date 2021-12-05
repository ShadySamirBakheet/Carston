package com.ozady.carston.views.news_reviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ozady.carston.databinding.ActivityAddCarReviewsBinding
import com.ozady.carston.databinding.ActivityViewCarBinding
import com.ozady.carston.views.notifications.NotificationsListActivity
import com.ozady.carston.views.search.SearchActivity

class AddCarReviewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCarReviewsBinding

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddCarReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}