package com.ozady.carston.views.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivityNotificationsListBinding
import com.ozady.carston.databinding.ActivityNotificationsViewBinding

class NotificationsViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotificationsViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}