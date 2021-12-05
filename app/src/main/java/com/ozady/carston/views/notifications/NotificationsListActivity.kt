package com.ozady.carston.views.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.notification.NotificationAdapter
import com.ozady.carston.databinding.ActivityNotificationsListBinding

class NotificationsListActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotificationsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notifyList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NotificationAdapter(context)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}