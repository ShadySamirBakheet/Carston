package com.ozady.carston.views.cars

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.CarreraVariantsAdapter
import com.ozady.carston.adapters.data.compare.CompareCarAdapter
import com.ozady.carston.adapters.data.cars.SpecificationsAdapter
import com.ozady.carston.adapters.data.cars.UserReviewAdapter
import com.ozady.carston.adapters.slider.SliderCarAdapter
import com.ozady.carston.databinding.ActivityCarViewBinding
import com.ozady.carston.views.payments.PaymentMethodActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class CarViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.titleReview.setOnClickListener {
            startActivity(Intent(this, ViewCarActivity::class.java).putExtra("tabNum",2))
        }

        binding.titleCompare.setOnClickListener {
            startActivity(Intent(this, CompareListActivity::class.java))
        }

        binding.btnApplyFinance.setOnClickListener {
            startActivity(Intent(this, PaymentMethodActivity::class.java))
        }

        binding.variants.setOnClickListener {
            startActivity(Intent(this, ViewCarActivity::class.java).putExtra("tabNum",1))
        }

        binding.specificationsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CarViewActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = SpecificationsAdapter(this@CarViewActivity)
        }

        binding.userReviewList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CarViewActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = UserReviewAdapter(this@CarViewActivity)
        }

        binding.compareList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CarViewActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = CompareCarAdapter(this@CarViewActivity)
        }

        binding.variantsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CarViewActivity)
            adapter = CarreraVariantsAdapter(this@CarViewActivity)
        }

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderCarAdapter(this@CarViewActivity))
        }


        binding.galleryList.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderCarAdapter(this@CarViewActivity))
        }

        binding.priceSelect.addOnChangeListener { slider, value, fromUser ->
            if (fromUser){
                binding.priceing.text = "$${value*100}"
                binding.showPrice.text = "$${value*100}"
            }
        }

        binding.yearsSelect.addOnChangeListener { slider, value, fromUser ->
            if (fromUser){
                binding.yearsNum.text = "${value} Years"
                binding.showYear.text = "Par maonth for  ${value} Years"
            }
        }

        binding.btnCall.setOnClickListener {
            callNumber("+201207090513")
        }

    }

    private fun callNumber(phone:String) {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                1
            )
        }else{
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:" +phone)
            startActivity(callIntent)
        }

    }

}