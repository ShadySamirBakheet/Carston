package com.ozady.carston.views.login_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivityConfirmCodeBinding

class ConfirmCodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}