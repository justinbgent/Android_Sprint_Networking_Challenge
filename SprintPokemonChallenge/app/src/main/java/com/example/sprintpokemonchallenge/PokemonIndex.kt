package com.example.sprintpokemonchallenge

data class PokemonIndex(val count: Int, val results: List<Pokemon>)

data class Pokemon(val name: String, val url: String)
//"front_default"