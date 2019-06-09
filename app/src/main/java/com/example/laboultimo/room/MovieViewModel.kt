package com.example.laboultimo.room

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(private val app:Application) : AndroidViewModel(app){
    private val repository : MovieRepository

    init {
        val repoDao = RoomDB2.getInstance(app).repoDao()
        repository = MovieRepository(repoDao)
    }

    fun retrieveMovie(clue : String) = viewModelScope.launch {
        this@MovieViewModel.nuke()
        val response = repository.retrieveRepoAsync(clue).await()
        if(response.isSuccessful) with(response){
            this.body()?.forEach{
                this@MovieViewModel.insert(it)
                Toast.makeText(app, "pelicula  encontrada" + it, Toast.LENGTH_LONG).show()
                Log.d("terminado"," pelicula encontrada")
                Log.d("terminado",it.totalResults)
            }
        }else with(response){
            Log.d("error",response.toString())
            when(this.code()){
                404->{
                    Toast.makeText(app, "pelicula no encontrada", Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    private suspend fun insert(movie:Coincidencia)=repository.insert(movie)

    fun getAll(): LiveData<List<Coincidencia>> {
        return repository.getAll()
    }

    private suspend fun nuke()=repository.nuke()
}