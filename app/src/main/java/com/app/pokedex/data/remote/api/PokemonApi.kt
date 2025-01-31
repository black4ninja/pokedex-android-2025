package com.app.pokedex.data.remote.api

import com.app.pokedex.data.remote.dto.PokemonDto
import com.app.pokedex.data.remote.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonListDto

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: String,
    ): PokemonDto
}
