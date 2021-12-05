package com.ozady.carston.views.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ozady.carston.databinding.ActivityRatingAppBinding

class RatingAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRatingAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRatingAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}