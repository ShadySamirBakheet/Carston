package com.ozady.carston.views.news_reviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.adapters.data.news.MostReadNewsAdapter
import com.ozady.carston.adapters.data.news.NewsAdapter
import com.ozady.carston.adapters.data.news.UserStoryAdapter
import com.ozady.carston.adapters.data.search.FilterPriceAdapter
import com.ozady.carston.databinding.ActivityNewsAndReviewsBinding
import com.ozady.carston.views.notifications.NotificationsListActivity
import com.ozady.carston.views.search.SearchActivity

class NewsAndReviewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsAndReviewsBinding
    private lateinit var storyAdapter: UserStoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsAndReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = MostReadNewsAdapter(context)
        }

        binding.useStoryList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            storyAdapter = UserStoryAdapter(context)
            adapter = storyAdapter

            storyAdapter.setOnItemClickListener {
                showStoryTypeFun()
            }
        }

        binding.newsAllList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NewsAdapter(context)
        }


        binding.goSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }

    private fun showStoryTypeFun() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_story_type, null)

        val addText = dialogLayout.findViewById<CardView>(R.id.addText)
        val addImage = dialogLayout.findViewById<CardView>(R.id.addImage)
        val addFromCam = dialogLayout.findViewById<CardView>(R.id.addFromCam)

        alertDialogBuilder.setView(dialogLayout)
        val alertDialog = alertDialogBuilder.create()

        addText.setOnClickListener {
            startActivity(Intent(this, AddStoryActivity::class.java).putExtra("typeStory",1))
            alertDialog.dismiss()
        }

        addImage.setOnClickListener {
            startActivity(Intent(this, AddStoryActivity::class.java).putExtra("typeStory",2))
            alertDialog.dismiss()
        }

        addFromCam.setOnClickListener {
            startActivity(Intent(this, AddStoryActivity::class.java).putExtra("typeStory",3))
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}