package com.ozady.carston.views.login_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ozady.carston.R
import com.ozady.carston.databinding.ActivityUserUpdateBinding

class UserUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.area.adapter = ArrayAdapter<String>(this, R.layout.item_spinner, arrayOf("Area 1","Area 1","Area 1","Area 1","Area 1","Area 1","Area 1",))

    }
}