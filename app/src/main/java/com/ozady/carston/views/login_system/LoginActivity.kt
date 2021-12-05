package com.ozady.carston.views.login_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozady.carston.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgetPassword.setOnClickListener{
            startActivity(
                Intent(this, ForgetPasswordActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }

        binding.btnSignUp.setOnClickListener{
            startActivity(
                Intent(this, SignupActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }


    }
}