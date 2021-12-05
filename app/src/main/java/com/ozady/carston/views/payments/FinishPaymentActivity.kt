package com.ozady.carston.views.payments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivityConfirmPaymentBinding
import com.ozady.carston.databinding.ActivityFinishPaymentBinding

class FinishPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinishPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}