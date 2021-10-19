package com.mdapp.diablocharactermdapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    var splashScreen: VideoView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashScreen = findViewById(R.id.splash_video)

        val path = "android.resource://" + packageName + "/" + R.raw.splash_screen1
        val uri = Uri.parse(path)

        splashScreen!!.setVideoURI(uri)
        splashScreen!!.start()

        splashScreen!!.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        splashScreen!!.setOnCompletionListener {
            if (isFinishing) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        splashScreen = findViewById(R.id.splash_video)

        val path = "android.resource://" + packageName + "/" + R.raw.splash_screen1
        val uri = Uri.parse(path)

        splashScreen!!.setVideoURI(uri)
        splashScreen!!.start()

        splashScreen!!.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        splashScreen!!.setOnCompletionListener {
            if (isFinishing) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}