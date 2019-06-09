package com.example.laboultimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboultimo.adapter.MovieAdapter
import com.example.laboultimo.room.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : MovieAdapter
    lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        adapter= MovieAdapter(ArrayList())
        viewModel= ViewModelProviders.of(this).get(MovieViewModel::class.java)

        rv_moview.apply {
            adapter=this@MainActivity.adapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }

        btn_search.setOnClickListener {
            viewModel.retrieveMovie(et_clue.text.toString())
        }
    }
}
