package com.mdapp.wallpapermdapp.model

import android.content.Context
import java.io.Serializable

class Items : Serializable {
    var icon: Int? = null
    var name: String? = null
    var context: String? = null

    constructor(icon: Int?, name: String?, context: String?) {
        this.icon = icon
        this.name = name
        this.context = context
    }
}