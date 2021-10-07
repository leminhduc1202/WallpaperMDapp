package com.mdapp.wallpapermdapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView
import com.mdapp.wallpapermdapp.R
import com.mdapp.wallpapermdapp.model.SliderItems

class SliderAdapter internal constructor(
    sliderItems: MutableList<SliderItems>,
    viewPaper : ViewPager2
): RecyclerView.Adapter<SliderAdapter.SliderViewHolder>(){

    private val sliderItems: List<SliderItems>
    init {
        this.sliderItems = sliderItems
    }

    class SliderViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView){
        private val imageView : RoundedImageView = itemsView.findViewById(R.id.image_slide)


        fun image(sliderItems: SliderItems){
            imageView.setImageResource(sliderItems.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_items_container, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image(sliderItems[position])
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

}