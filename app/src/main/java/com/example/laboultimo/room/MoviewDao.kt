package com.example.laboultimo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie:Coincidencia)

    @Query("SELECT * FROM coincidencia")
    fun getAllMovies():LiveData<List<Coincidencia>>

    @Query("DELETE FROM coincidencia")
    suspend fun nukeTable()

}