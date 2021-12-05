package com.ozady.carston.views.payments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.payments.PaymentMethodAdapter
import com.ozady.carston.databinding.ActivityPaymentMethodBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class PaymentMethodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentMethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.paymentMethodList.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = PaymentMethodAdapter(context)
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.goNext.setOnClickListener {
            startActivity(Intent(this, ConfirmPaymentActivity::class.java))
        }

    }
}