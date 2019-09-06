package com.example.sprintpokemonchallenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.model.Pokemon
import com.example.sprintpokemonchallenge.model.PokemonDetail
import com.example.sprintpokemonchallenge.model.PokemonIndex
import com.example.sprintpokemonchallenge.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<PokemonIndex> {

    companion object {
        var pokemonList: List<Pokemon>? = listOf()
        lateinit var pokemonInfo: PokemonDetail
    }

    override fun onFailure(call: Call<PokemonIndex>, t: Throwable) {
        Log.i("IsWorking", "No")
    }

    override fun onResponse(call: Call<PokemonIndex>, response: Response<PokemonIndex>) {
        val intent = Intent(this, ListOfPokemon::class.java)
        pokemonList = response.body()?.results
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            RetrofitInstance.getPokemon(edit_txt.text.toString().toLowerCase()).enqueue(object: Callback<PokemonDetail>{
                override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                }

                override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                    if (response.body() != null){
                        pokemonInfo = response.body() as PokemonDetail

                        val intent = Intent(this@MainActivity, PokemonDetailsActivity::class.java)
                        startActivity(intent)
                    }
                }
            })

        }

        btn_list.setOnClickListener {
            RetrofitInstance.getPokemonIndex().enqueue(this)
        }
    }
}
