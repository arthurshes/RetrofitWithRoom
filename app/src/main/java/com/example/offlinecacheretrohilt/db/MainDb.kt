package com.example.offlinecacheretrohilt.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restoran::class], version = 1)
abstract class MainDb:RoomDatabase() {
    abstract fun getDao():Dao

}