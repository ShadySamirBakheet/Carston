package com.ozady.carston.views.login_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivitySplashLogin2Binding

class SplashLogin2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            startActivity(
                Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }

    }
}