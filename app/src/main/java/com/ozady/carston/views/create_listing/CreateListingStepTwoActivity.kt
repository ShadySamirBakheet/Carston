package com.ozady.carston.views.create_listing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.ads.AdsPackageAdapter
import com.ozady.carston.databinding.ActivityCreateListingStepTwoBinding

class CreateListingStepTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateListingStepTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateListingStepTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.adPackageList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CreateListingStepTwoActivity,
                LinearLayoutManager.HORIZONTAL,false)
            adapter = AdsPackageAdapter(this@CreateListingStepTwoActivity)
        }


        binding.goNext.setOnClickListener {
            startActivity(Intent(this,CreateListingStepThreeActivity::class.java))
            finish()
        }


    }
}