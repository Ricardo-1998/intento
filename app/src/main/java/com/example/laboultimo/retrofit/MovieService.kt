package com.example.laboultimo.retrofit

import android.util.Log
import com.example.laboultimo.room.Coincidencia
import com.example.laboultimo.room.Movie

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*
import java.util.concurrent.TimeUnit


const val MOVIE_API_BASE_URL = "http://www.omdbapi.com/?"
//http://www.omdbapi.com/?s=avengers&apikey=d6c84f8c

interface MovieService{
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("/")
    fun getMovies(@Query("s")clue : String, @Query("apikey") apikey:String) : Deferred<Response<List<Coincidencia>>>

    companion object {
            fun getMovieService(): MovieService{

            return Retrofit.Builder()
                .baseUrl(MOVIE_API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(MovieService::class.java)
        }
    }


}