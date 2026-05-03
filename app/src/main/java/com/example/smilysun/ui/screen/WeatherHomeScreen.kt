package com.example.smilysun.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smilysun.model.WeatherDay
import com.example.smilysun.ui.component.SavedLocationsSection

/**
 * WeatherHomeScreen = écran météo principal de SmilySun.
 *
 * Dans la V1, cet écran affiche une météo fictive statique
 * ainsi qu’une première section temporaire de villes sauvegardées.
 */
@Composable
fun WeatherHomeScreen(
    weather: WeatherDay,
    savedLocations: List<WeatherDay>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SmilySun", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = weather.city, fontSize = 20.sp)
        Text(text = "${weather.emoji} ${weather.temperature}°C", fontSize = 40.sp)
        Text(text = weather.condition, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = weather.message, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(24.dp))

        SavedLocationsSection(locations = savedLocations)
    }
}
