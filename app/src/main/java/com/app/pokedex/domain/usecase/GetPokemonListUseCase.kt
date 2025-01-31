package com.app.pokedex.domain.usecase

import com.app.pokedex.domain.model.Pokemon
import com.app.pokedex.domain.repository.PokemonRepository
import com.app.pokedex.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase
    @Inject
    constructor(
        private val repository: PokemonRepository,
    ) {
        operator fun invoke(): Flow<Result<List<Pokemon>>> =
            flow {
                try {
                    emit(Result.Loading)
                    val pokemonList = repository.getPokemonList()
                    emit(Result.Success(pokemonList))
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
