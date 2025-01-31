package com.app.pokedex.presentation.screens.detail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.pokedex.domain.model.Pokemon

@Suppress("ktlint:standard:function-naming")
@Composable
fun PokemonDetailContent(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    var imageLoaded by remember { mutableStateOf(false) }

    Column(
        modifier =
            modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
        ) {
            AsyncImage(
                model = pokemon.imageUrl,
                contentDescription = pokemon.name,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .scale(if (imageLoaded) 1f else 0.8f)
                        .alpha(if (imageLoaded) 1f else 0f)
                        .animateContentSize(),
                onSuccess = { imageLoaded = true },
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        PokemonInfo(
            pokemon = pokemon,
            modifier = Modifier.animateContentSize(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        PokemonTypes(
            types = pokemon.types,
            modifier = Modifier.animateContentSize(),
        )
    }
}
