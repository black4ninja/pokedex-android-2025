package com.app.pokedex.data.repository

import com.app.pokedex.data.mapper.toDomain
import com.app.pokedex.data.remote.api.PokemonApi
import com.app.pokedex.domain.model.Pokemon
import com.app.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl
    @Inject
    constructor(
        private val api: PokemonApi,
    ) : PokemonRepository {
        override suspend fun getPokemonList(): List<Pokemon> {
            val response = api.getPokemonList()
            return response.results.map { result ->
                val id =
                    result.url
                        .split("/")
                        .dropLast(1)
                        .last()
                api.getPokemon(id).toDomain()
            }
        }

        override suspend fun getPokemonById(id: String): Pokemon = api.getPokemon(id).toDomain()
    }
