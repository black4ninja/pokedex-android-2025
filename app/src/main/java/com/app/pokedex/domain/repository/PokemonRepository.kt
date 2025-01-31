package com.app.pokedex.domain.repository

import com.app.pokedex.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>

    suspend fun getPokemonById(id: String): Pokemon
}
