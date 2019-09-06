package com.example.sprintpokemonchallenge

import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi{
    @GET("/?limit=964")
    fun getPokemonIndex(): Call<PokemonIndex>

    @GET("/{id}")
    fun getPokemonById(): Call<Pokemon>

    @GET("/{name}")
    fun getPokemonByName(): Call<Pokemon>
}