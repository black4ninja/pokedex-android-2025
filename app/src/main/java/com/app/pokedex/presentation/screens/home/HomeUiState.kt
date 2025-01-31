package com.app.pokedex.presentation.screens.home

import com.app.pokedex.domain.model.Pokemon

data class HomeUiState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
