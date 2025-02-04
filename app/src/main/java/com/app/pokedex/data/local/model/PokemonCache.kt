package com.app.pokedex.data.local.model

import com.app.pokedex.domain.model.Pokemon

data class PokemonCache(
    val pokemonList: List<Pokemon>,
    val lastUpdate: Long,
    val offset: Int,
    val totalCount: Int,
)
