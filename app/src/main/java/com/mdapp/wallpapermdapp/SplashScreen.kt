package com.mdapp.wallpapermdapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    var splashScreen: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashScreen = findViewById(R.id.splash_video)

        val path = "android.resource://" + packageName + "/" + R.raw.splash_screen
        val uri = Uri.parse(path)
        splashScreen!!.setVideoURI(uri)
        splashScreen!!.start()

        splashScreen!!.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        splashScreen!!.setOnCompletionListener {
            if (isFinishing){
                startActivity(Intent(this,HomeActivity::class.java))
            }
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}