package com.ozady.carston.views.news_reviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.R
import com.ozady.carston.adapters.data.news.CommentNewsAdapter
import com.ozady.carston.adapters.data.news.NewsAdapter
import com.ozady.carston.databinding.ActivityChooseCarBinding
import com.ozady.carston.databinding.ActivityViewNewsDetailsBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class ViewNewsDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.likeCount.setOnClickListener {
            binding.likeImg.setColorFilter(ContextCompat.getColor(this, R.color.btnColor1))
            binding.likeText.text = "1505"
        }

        binding.commentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CommentNewsAdapter(context)
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }
    }
}