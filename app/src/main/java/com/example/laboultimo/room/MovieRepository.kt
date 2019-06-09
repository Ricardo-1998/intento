package com.example.laboultimo.room

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.laboultimo.retrofit.MovieService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepository(private val movieRepoDao : MovieDao){

    fun retrieveRepoAsync(clue:String) : Deferred<Response<List<Coincidencia>>>{
        val paso = "d6c84f8c"

        return MovieService.getMovieService().getMovies(clue,paso)
    }

    @WorkerThread
    suspend fun insert(movie:Coincidencia){
        movieRepoDao.insert(movie)
    }

    fun getAll(): LiveData<List<Coincidencia>> {
        return movieRepoDao.getAllMovies()
    }

    @WorkerThread
    suspend fun nuke(){
        return movieRepoDao.nukeTable()
    }
}