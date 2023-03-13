package com.example.offlinecacheretrohilt.db
import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRest(restoran:List<Restoran>)

    @Query("DELETE FROM restTable")
    suspend fun deleteAllRestoran()

    @Query("SELECT * FROM restTable")
    fun getAllrest():Flow<List<Restoran>>
}