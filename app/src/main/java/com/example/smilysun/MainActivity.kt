package com.example.smilysun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * MainActivity = point d’entrée Android
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
 * SmilySunApp = racine Compose
 */
@Composable
fun SmilySunApp() {
    HomeScreen()
}

/**
 * HomeScreen = écran principal
 */
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text("SmilySun")
        Text("Montréal")
        Text("☀️ 22°C")
        Text("Ensoleillé")
    }
}