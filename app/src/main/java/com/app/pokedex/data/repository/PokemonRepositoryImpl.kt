package com.app.pokedex.data.repository

import com.app.pokedex.data.local.preferences.PokemonPreferences
import com.app.pokedex.data.mapper.toDomain
import com.app.pokedex.data.remote.api.PokemonApi
import com.app.pokedex.domain.model.Pokemon
import com.app.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl
    @Inject
    constructor(
        private val api: PokemonApi,
        private val preferences: PokemonPreferences,
    ) : PokemonRepository {
        override suspend fun getPokemonList(): List<Pokemon> {
            // Intentar obtener del caché primero
            preferences.getPokemonCache()?.let { cache ->
                if (preferences.isCacheValid()) {
                    return cache.pokemonList
                }
            }

            return try {
                // Si no hay caché o expiró, obtener de la API
                val response = api.getPokemonList()
                val pokemonList =
                    response.results.map { result ->
                        val id =
                            result.url
                                .split("/")
                                .dropLast(1)
                                .last()
                        api.getPokemon(id).toDomain()
                    }

                // Guardar en caché
                preferences.savePokemonList(
                    pokemonList = pokemonList,
                    offset = pokemonList.size,
                    totalCount = response.count,
                )

                pokemonList
            } catch (e: Exception) {
                // Si hay error, intentar usar caché aunque haya expirado
                preferences.getPokemonCache()?.let { cache ->
                    return cache.pokemonList
                } ?: throw e
            }
        }

        override suspend fun getPokemonById(id: String): Pokemon {
            // Intentar obtener del caché primero
            preferences.getPokemonCache()?.let { cache ->
                if (preferences.isCacheValid()) {
                    cache.pokemonList.find { it.id == id }?.let { return it }
                }
            }

            return try {
                // Si no está en caché o expiró, obtener de la API
                api.getPokemon(id).toDomain()
            } catch (e: Exception) {
                // Si hay error, intentar buscar en caché aunque haya expirado
                preferences.getPokemonCache()?.let { cache ->
                    cache.pokemonList.find { it.id == id }
                } ?: throw e
            }
        }
    }
