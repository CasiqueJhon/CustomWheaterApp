package com.example.customwheaterapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class CityUpdate(
    @ColumnInfo(name= "id")
    var id:Int?=null,

    @ColumnInfo(name= "isSaved")
    var isSaved:Int?=null
)
