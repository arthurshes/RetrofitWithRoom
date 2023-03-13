package com.example.offlinecacheretrohilt.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restTable")
data class Restoran(
@PrimaryKey     val id: Int,
    val logo: String,
    val name: String,
    val type: String,
    val address: String
)