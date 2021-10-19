package com.mdapp.diablocharactermdapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.diablocharactermdapp.adapter.SliderAdapter
import com.mdapp.diablocharactermdapp.model.SliderItems
import kotlin.math.abs

class WallpaperActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)

        viewPager2 = findViewById(R.id.view_paper2_imageslider)

        val sliderItems: MutableList<SliderItems> = ArrayList()
        sliderItems.add(SliderItems(R.drawable.barbarian))
        sliderItems.add(SliderItems(R.drawable.amazon))
        sliderItems.add(SliderItems(R.drawable.druid))
        sliderItems.add(SliderItems(R.drawable.assassin))
        sliderItems.add(SliderItems(R.drawable.paladin))
        sliderItems.add(SliderItems(R.drawable.necromancer))
        sliderItems.add(SliderItems(R.drawable.sorceress))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f
        }

        viewPager2.setPageTransformer(compositePageTransformer)

    }
}