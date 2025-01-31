package com.app.pokedex.presentation.screens.detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.pokedex.presentation.theme.getPokemonTypeColor

@Suppress("ktlint:standard:function-naming")
@Composable
fun TypeChip(type: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = getPokemonTypeColor(type),
        contentColor = Color.White,
    ) {
        Text(
            text = type.replaceFirstChar { it.uppercase() },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
