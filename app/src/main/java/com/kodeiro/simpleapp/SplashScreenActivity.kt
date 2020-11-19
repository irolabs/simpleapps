package com.kodeiro.simpleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intentToMain = Intent(this@SplashScreenActivity,MainActivity::class.java)
            startActivity(intentToMain)
            finish()
        },2000)

    }
}