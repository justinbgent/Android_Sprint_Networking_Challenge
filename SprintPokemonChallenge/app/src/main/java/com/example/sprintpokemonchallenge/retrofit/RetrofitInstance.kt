package com.example.sprintpokemonchallenge.retrofit

import com.example.sprintpokemonchallenge.api.PokemonApi
import com.example.sprintpokemonchallenge.model.PokemonIndex
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

    fun getPokemonIndex(): Call<PokemonIndex>{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(PokemonApi::class.java).getPokemonIndex()

    }

    fun getPokemon(): Call<PokemonIndex>{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(PokemonApi::class.java).getPokemonIndex()

    }
}