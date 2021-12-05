package com.ozady.carston.views.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ozady.carston.adapters.data.home.BodyCarAdapter
import com.ozady.carston.databinding.ActivityViewBodyCarsBinding
import com.ozady.carston.views.notifications.NotificationsListActivity

class ViewBodyCarsActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewBodyCarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBodyCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.goNotify.setOnClickListener {
            startActivity(Intent(this, NotificationsListActivity::class.java))
        }

        binding.bodyCarList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            adapter = BodyCarAdapter(context, false, false)
        }

    }
}