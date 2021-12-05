package com.ozady.carston.views.create_listing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivityCreateListingStepThreeBinding
import com.ozady.carston.databinding.ActivityCreateListingStepTwoBinding

class CreateListingStepThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateListingStepThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateListingStepThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}