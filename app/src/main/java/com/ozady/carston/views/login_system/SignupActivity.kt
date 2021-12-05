package com.ozady.carston.views.login_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ozady.carston.R
import com.ozady.carston.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.codeCountry.adapter = ArrayAdapter<String>(this, R.layout.item_spinner, arrayOf("Eg +20"))

    }
}