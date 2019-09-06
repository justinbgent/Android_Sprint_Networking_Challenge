package com.example.sprintpokemonchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.model.PokemonDetail
import com.example.sprintpokemonchallenge.ui.MainActivity.Companion.pokemonInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.recycler_item.*

class PokemonDetailsActivity : AppCompatActivity() {

    companion object{
        lateinit var searchedPokemon: ArrayList<PokemonDetail>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        //Logic to keep track of user's searched pokemon. Ensured repeats won't show up.
        var addPokemonToList = true
        if (searchedPokemon.size < 1){
            searchedPokemon.add(pokemonInfo)
            addPokemonToList = false
        }
        else {
            for (i in searchedPokemon.indices){
                if(searchedPokemon[i] == pokemonInfo){
                    addPokemonToList = false
                    break
                }
            }
        }
        if (addPokemonToList){
            searchedPokemon.add(pokemonInfo)
        }




        Picasso.get().load(pokemonInfo.sprites.pokemonSprite).into(image_sprite)
        txt_pokemon_name.text = pokemonInfo.name
        txt_id.text = pokemonInfo.id.toString()

        pokemonInfo.sprites
        pokemonInfo.types

        var abilities = ""
        for (i in pokemonInfo.abilities.indices){
            abilities += "-${pokemonInfo.abilities[i].ability.name} "
        }
        txt_abilities.text = abilities


        var types = ""
        for (i in pokemonInfo.types.indices){
            types += "-${pokemonInfo.types[i].type.name} "
        }
        txt_types.text = types

    }
}
