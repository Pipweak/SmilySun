package com.example.smilysun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

/**
 * MainActivity = point d’entrée Android.
 *
 * Cette classe est lancée par Android quand l’utilisateur ouvre l’app.
 * Son rôle est de démarrer l’interface Compose avec `setContent`.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SmilySunApp()
        }
    }
}

/**
 * SmilySunApp = racine Compose de l’application.
 *
 * Pour l’instant, elle affiche seulement l’écran principal.
 * Plus tard, elle pourra contenir le thème global ou la navigation.
 */
@Composable
fun SmilySunApp() {
    val todayWeather = WeatherDay(
        city = "Montréal",
        temperature = 22,
        condition = "Ensoleillé",
        emoji = "☀️",
        message = "Belle journée pour sortir un peu."
    )

    HomeScreen(weather = todayWeather)
}

/**
 * HomeScreen = écran principal de SmilySun.
 *
 * Dans la V1, cet écran affiche une météo fictive statique.
 */
@Composable
fun HomeScreen(weather: WeatherDay) {

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
    }
}