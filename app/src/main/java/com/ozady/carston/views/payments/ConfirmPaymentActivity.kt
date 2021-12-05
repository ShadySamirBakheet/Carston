package com.ozady.carston.views.payments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ozady.carston.databinding.ActivityConfirmPaymentBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class ConfirmPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConfirmPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.goNext.setOnClickListener {
            startActivity(Intent(this, FinishPaymentActivity::class.java))
        }

    }
}