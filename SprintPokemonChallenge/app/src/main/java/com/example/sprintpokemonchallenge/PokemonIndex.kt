package com.example.sprintpokemonchallenge

data class PokemonIndex(val count: Int, val results: List<Pokemon>)

data class Pokemon(val name: String, val url: String)

data class PokemonDetail(val abilities: List<Ability>)
//Next two data class's help flesh out the above class, See parameters
data class Ability(val ability: AbilityDetails)

data class AbilityDetails(val name: String, val url: String)
//"front_default"