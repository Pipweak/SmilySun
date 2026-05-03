package com.example.smilysun.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smilysun.model.WeatherDay

/**
 * SavedLocationsSection = section temporaire qui affiche les villes sauvegardées.
 *
 * Plus tard, cette section ira probablement dans un vrai écran :
 * SavedLocationsScreen.
 */
@Composable
fun SavedLocationsSection(locations: List<WeatherDay>) {
    Column {
        Text(text = "Mes endroits", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        locations.forEach { weather ->
            SavedLocationRow(weather = weather)
        }
    }
}
