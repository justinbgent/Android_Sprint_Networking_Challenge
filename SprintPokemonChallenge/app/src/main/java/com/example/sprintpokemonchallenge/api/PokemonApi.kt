package com.example.sprintpokemonchallenge.api

import com.example.sprintpokemonchallenge.model.Pokemon
import com.example.sprintpokemonchallenge.model.PokemonIndex
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi{
    @GET("?limit=964")
    fun getPokemonIndex(): Call<PokemonIndex>

    @GET("/{id}")
    fun getPokemonById(): Call<Pokemon>

    @GET("/{name}")
    fun getPokemonByName(): Call<Pokemon>
}