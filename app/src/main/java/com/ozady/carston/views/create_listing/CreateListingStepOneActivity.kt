package com.ozady.carston.views.create_listing

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ozady.carston.databinding.ActivityCreateListingStepOneBinding

class CreateListingStepOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateListingStepOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateListingStepOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNext.setOnClickListener {
            startActivity(Intent(this,CreateListingStepTwoActivity::class.java))
            finish()
        }

        binding.individual.setOnCheckedChangeListener { compoundButton, isChecked ->
            binding.dealer.isChecked = !isChecked
        }

        binding.dealer.setOnCheckedChangeListener { compoundButton, isChecked ->
            binding.individual.isChecked = !isChecked
        }


    }
}