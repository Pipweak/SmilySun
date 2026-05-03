package com.example.smilysun.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.smilysun.model.WeatherDay

/**
 * SavedLocationRow = ligne d’une ville sauvegardée.
 *
 * Ce composant servira plus tard dans l’écran "Mes endroits".
 * Pour l’instant, il affiche une version simple avec le modèle temporaire WeatherDay.
 */
@Composable
fun SavedLocationRow(weather: WeatherDay) {
    Text(text = "${weather.city} — ${weather.emoji} ${weather.temperature}°C")
}
