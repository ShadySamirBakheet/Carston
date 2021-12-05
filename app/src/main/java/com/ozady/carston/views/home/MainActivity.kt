package com.ozady.carston.views.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.ozady.carston.R
import com.ozady.carston.utils.Methods
import com.ozady.carston.utils.Methods.Companion.setLocale
import com.ozady.carston.views.login_system.ChangePasswordActivity
import com.ozady.carston.views.login_system.ConfirmCodeActivity
import com.ozady.carston.views.login_system.SplashLoginActivity
import com.ozady.carston.views.login_system.UserUpdateActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setAnimation()

        //setLocale("ar", this)

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        },4000)
    }

    private fun setAnimation() {
        val container = findViewById<ImageView>(R.id.startImg)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.splash_move2)
        animation.duration = 2000
        container.startAnimation(animation)
    }

}