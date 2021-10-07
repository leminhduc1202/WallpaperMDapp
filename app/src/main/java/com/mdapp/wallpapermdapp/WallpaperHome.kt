package com.mdapp.wallpapermdapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.mdapp.wallpapermdapp.model.Items

class WallpaperHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wallpaper_home)

        var modelItems: Items = intent.getSerializableExtra("data") as Items

        findViewById<TextView>(R.id.name_text_view).text = modelItems.context
        findViewById<ImageView>(R.id.icon).setImageResource(modelItems.icon!!)
    }
}