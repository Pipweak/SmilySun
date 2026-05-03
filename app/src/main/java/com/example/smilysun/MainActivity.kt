package com.example.smilysun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.smilysun.ui.SmilySunApp

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
