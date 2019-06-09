package com.example.laboultimo.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "coincidencia")
data class Coincidencia(

    @PrimaryKey
    @field:Json(name="search")
    var imdbID : String,
    @field:Json(name="totalResults")
    var totalResults : String,
    @field:Json(name="response")
    var response : String

)