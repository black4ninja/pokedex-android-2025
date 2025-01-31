package com.app.pokedex.domain.usecase

import com.app.pokedex.domain.model.Pokemon
import com.app.pokedex.domain.repository.PokemonRepository
import com.app.pokedex.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonUseCase
    @Inject
    constructor(
        private val repository: PokemonRepository,
    ) {
        operator fun invoke(id: String): Flow<Result<Pokemon>> =
            flow {
                try {
                    emit(Result.Loading)
                    val pokemon = repository.getPokemonById(id)
                    emit(Result.Success(pokemon))
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
