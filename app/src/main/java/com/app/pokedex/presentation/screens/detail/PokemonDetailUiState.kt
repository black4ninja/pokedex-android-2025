package com.app.pokedex.presentation.screens.detail

import com.app.pokedex.domain.model.Pokemon

data class PokemonDetailUiState(
    val pokemon: Pokemon? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
