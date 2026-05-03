package com.example.smilysun.ui

import androidx.compose.runtime.Composable
import com.example.smilysun.data.FakeWeatherRepository
import com.example.smilysun.ui.screen.HomeScreen

/**
 * SmilySunApp = racine Compose de l’application.
 *
 * Pour l’instant, elle prépare les données fictives et affiche l’écran principal.
 * Plus tard, elle pourra contenir le thème global, l’état de navigation
 * ou le choix de la ville active.
 */
@Composable
fun SmilySunApp() {
    HomeScreen(
        weather = FakeWeatherRepository.todayWeather,
        savedLocations = FakeWeatherRepository.savedLocations
    )
}
