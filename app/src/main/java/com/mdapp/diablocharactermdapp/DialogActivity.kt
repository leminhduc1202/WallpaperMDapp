package com.mdapp.diablocharactermdapp


import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.mdapp.diablocharactermdapp.model.Items

class DialogActivity : AppCompatActivity() {

    var modelItems: Items? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        modelItems = intent.getSerializableExtra("data") as Items

        var playVideoCharacter = findViewById<VideoView>(R.id.dialog_fragment)
        playVideoCharacter.setVideoURI(Uri.parse(modelItems?.videoView!!))
        playVideoCharacter.start()
        playVideoCharacter.setOnCompletionListener {
            playVideoCharacter.start()
        }

        findViewById<Button>(R.id.set_wallpaper).setOnClickListener {
            val wallpaperSet = modelItems?.icon!!
            val bitmap: Bitmap = BitmapFactory.decodeResource(resources, wallpaperSet)
            val wallPaperSet = WallpaperManager.getInstance(baseContext)
            wallPaperSet.setBitmap(bitmap)
            Toast.makeText(this, "Wallpaper set! ${modelItems?.name!!} ",Toast.LENGTH_LONG).show()
        }

    }

}