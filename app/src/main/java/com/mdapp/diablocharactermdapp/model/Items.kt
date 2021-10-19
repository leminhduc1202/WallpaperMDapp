package com.mdapp.diablocharactermdapp.model

import java.io.Serializable

class Items : Serializable {
    var icon: Int? = null
    var name: String? = null
    var context: String? = null
    var videoView : String? = null

    constructor(icon: Int?, name: String?, context: String?, videoView: String?) {
        this.icon = icon
        this.name = name
        this.context = context
        this.videoView = videoView
    }
}