package com.app.pokedex.data.mapper

import com.app.pokedex.data.remote.dto.PokemonDto
import com.app.pokedex.domain.model.Pokemon

fun PokemonDto.toDomain(): Pokemon =
    Pokemon(
        id = id.toString(),
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = sprites.frontDefault,
        weight = weight,
        height = height,
        types = types.map { it.type.name },
    )
