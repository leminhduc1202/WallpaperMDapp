package com.mdapp.diablocharactermdapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mdapp.diablocharactermdapp.R
import com.mdapp.diablocharactermdapp.model.Items

class Adapter(var context: Context, var arrayList: ArrayList<Items>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.card_view_items_grid, null)
        var icons: ImageView = view.findViewById(R.id.icon)
        var name: TextView = view.findViewById(R.id.name_text_view)

        var listerItems: Items = arrayList.get(p0)

        icons.setImageResource(listerItems.icon!!)
        name.text = listerItems.name


        return view
    }


}