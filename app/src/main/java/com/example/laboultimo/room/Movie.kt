package com.example.laboultimo.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "movie")
data class Movie(

    @PrimaryKey
    @field:Json(name="imdbID")
    var imdbID : String,
    @field:Json(name="title")
    var title : String,
    @field:Json(name="year")
    var year : String,
    @field:Json(name="type")
    var type : String,
    @field:Json(name="poster")
    var poster : String

)