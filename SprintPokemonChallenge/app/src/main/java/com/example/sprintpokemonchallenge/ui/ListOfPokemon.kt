package com.example.sprintpokemonchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.recyclerAdapter.RecyclerAdapter
import com.example.sprintpokemonchallenge.ui.MainActivity.Companion.pokemonList
import kotlinx.android.synthetic.main.activity_list_of_pokemon.*

class ListOfPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_pokemon)

        recycler.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = RecyclerAdapter(pokemonList)
        recycler.layoutManager = manager
        recycler.adapter = adapter
    }
}
