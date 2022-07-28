package com.novopay.navipullrequestassignment.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.novopay.navipullrequestassignment.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }, 3000

        )
    }
}