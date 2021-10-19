package com.mdapp.diablocharactermdapp

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.mdapp.diablocharactermdapp.model.Items

class WallpaperHome : AppCompatActivity() {

    var modelItems: Items? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wallpaper_home)
        modelItems = intent.getSerializableExtra("data") as Items

        findViewById<TextView>(R.id.name_text_view).text = modelItems?.context
        findViewById<ImageView>(R.id.icon).setImageResource(modelItems?.icon!!)

        var playVideoCharacter = findViewById<VideoView>(R.id.vd_character)
        playVideoCharacter.setVideoURI(Uri.parse(modelItems?.videoView!!))
        playVideoCharacter.start()
        playVideoCharacter.setOnCompletionListener {
                playVideoCharacter.start()
        }
    }
}




