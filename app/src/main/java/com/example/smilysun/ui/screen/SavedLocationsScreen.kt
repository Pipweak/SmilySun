package com.example.smilysun.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smilysun.model.WeatherDay
import com.example.smilysun.ui.component.SavedLocationsSection

/**
 * SavedLocationsScreen = écran "Mes endroits".
 *
 * Cet écran affichera les villes sauvegardées.
 * Pour l’instant, il est préparé sans navigation réelle.
 */
@Composable
fun SavedLocationsScreen(locations: List<WeatherDay>) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        SavedLocationsSection(locations = locations)
    }
}