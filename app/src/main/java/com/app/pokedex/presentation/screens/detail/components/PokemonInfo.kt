package com.app.pokedex.presentation.screens.detail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.pokedex.domain.model.Pokemon

@Suppress("ktlint:standard:function-naming")
@Composable
fun PokemonInfo(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .animateContentSize(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                InfoItem("Height", "${pokemon.height / 10.0}m")
                InfoItem("Weight", "${pokemon.weight / 10.0}kg")
            }
        }
    }
}
