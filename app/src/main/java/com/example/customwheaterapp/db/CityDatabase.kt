package com.example.customwheaterapp.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.customwheaterapp.utils.Constant.Companion.DB_NAME

abstract class CityDatabase: RoomDatabase() {
    abstract fun getCityDao(): CityDao

    companion object {
        private val MIGRATION_1_2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE city_bd ADD COLUMN isSaved INTEGER DEFAULT NULL")
            }
        }

        @Volatile
        private var instance:CityDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?:createDatabase(context).also{ instance=it}
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, CityDatabase::class.java, DB_NAME)
            .createFromAsset(DB_NAME)
            .addMigrations(MIGRATION_1_2)
            .build()
    }
}