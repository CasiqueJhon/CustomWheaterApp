package com.example.customwheaterapp.use_case

import com.google.gson.annotations.SerializedName

class Coord {
    @SerializedName("lon")
    var lon: Float = 0.toFloat()
    @SerializedName("lat")
    var lat: Float = 0.toFloat()
}