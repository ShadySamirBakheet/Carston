package com.ozady.carston.views.news_reviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.ozady.carston.databinding.ActivityNewsAndReviewsBinding
import com.ozady.carston.databinding.ActivityStoryViewBinding

class StoryViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoryViewBinding

    var isInPage = true
    var setps = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isInPage = true
        setps = 0

        binding.storyImg.setOnClickListener {
            isInPage = false
            finish()
        }

        setProgressFun()

        Handler().postDelayed({
            if (isInPage){
                isInPage = false
                finish()
            }
        },10000)
        ///Toast.makeText(this, "${((50.toFloat() / 100f) * 100f).toInt()}", Toast.LENGTH_SHORT).show()
    }

    private fun setProgressFun() {

        Handler().postDelayed({
            setps++

            binding.progTime.progress = ((setps.toFloat()/200f)*100f).toInt()
            ///binding.progTime2.progress = ((setps.toFloat()/200f)*100f).toInt()

            if (isInPage){
                setProgressFun()
            }

        },50)

    }
}