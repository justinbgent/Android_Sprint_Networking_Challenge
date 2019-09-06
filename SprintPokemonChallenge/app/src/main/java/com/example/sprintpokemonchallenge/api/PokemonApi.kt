package com.example.sprintpokemonchallenge.api

import com.example.sprintpokemonchallenge.model.PokemonDetail
import com.example.sprintpokemonchallenge.model.PokemonIndex
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi{
    @GET("?limit=964")
    fun getPokemonIndex(): Call<PokemonIndex>

    @GET("{IdOrName}")
    fun getPokemon(@Path("IdOrName")idOrName: String): Call<PokemonDetail>

//    @GET("{name}")
//    fun getPokemon(@Path("name")pokemonName: String): Call<PokemonDetail>
}