package com.example.sprintpokemonchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sprintpokemonchallenge.model.Pokemon
import com.example.sprintpokemonchallenge.model.PokemonIndex
import com.example.sprintpokemonchallenge.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<PokemonIndex> {

    companion object {
        var pokemon: List<Pokemon>? = listOf()
    }

    override fun onFailure(call: Call<PokemonIndex>, t: Throwable) {
        Log.i("IsWorking", "No")
    }

    override fun onResponse(call: Call<PokemonIndex>, response: Response<PokemonIndex>) {
        Log.i("IsWorking", "Yes")
        val intent = Intent(this, ListOfPokemon::class.java)
        pokemon = response.body()?.results
        Log.i("IsWorking", "${pokemon?.size}")
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            edit_txt.text
        }

        btn_list.setOnClickListener {
            RetrofitInstance.getPokemonIndex().enqueue(this)
        }
    }
}
