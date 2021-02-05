package com.example.customwheaterapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.customwheaterapp.models.Cities
import com.example.customwheaterapp.models.CityUpdate

@Dao
interface CityDao {

    @Query("SELECT * FROM city_bd WHERE name LIKE :key || '%'")
    suspend fun searchCity(key:String):List<Cities>

    @Update(entity = Cities::class)
    suspend fun updateSavedCity(vararg obj: CityUpdate):Int

    @Query("SELECT * FROM city_bd WHERE isSaved= :key")
    fun getSaveCity(key: Int):LiveData<List<Cities>>

    @Delete
    suspend fun deleteSavedCity(city: Cities)
}