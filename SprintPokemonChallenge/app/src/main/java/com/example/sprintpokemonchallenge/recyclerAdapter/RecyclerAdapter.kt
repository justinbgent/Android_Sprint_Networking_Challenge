package com.example.sprintpokemonchallenge.recyclerAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.model.Pokemon
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(private val pokemonIndex: List<Pokemon>?): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonIndex?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (pokemonIndex != null){
            val pokemon = pokemonIndex[position]
            holder.name.text = "YEAH"//pokemon.name
            Log.i("IsWorking", "Working")
        }else{
            Log.i("IsWorking", "Null")
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.txt_name
    }
}