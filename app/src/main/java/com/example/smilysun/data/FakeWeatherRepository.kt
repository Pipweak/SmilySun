package com.example.smilysun.data

import com.example.smilysun.model.WeatherDay

/**
 * FakeWeatherRepository = source de données météo fictives.
 *
 * Pour la V1, l’app n’utilise pas encore d’API météo.
 * Ce repository fournit donc des données locales écrites en dur.
 *
 * Important :
 * ce repository est temporaire. Plus tard, il pourra évoluer
 * ou être remplacé par une vraie source de données météo.
 */
object FakeWeatherRepository {

    val savedLocations = listOf(
        WeatherDay(
            city = "Montréal",
            temperature = 22,
            condition = "Ensoleillé",
            emoji = "☀️",
            message = "Belle journée pour sortir un peu."
        ),
        WeatherDay(
            city = "Tokyo",
            temperature = 27,
            condition = "Humide",
            emoji = "🌤️",
            message = "Chaud et lourd aujourd’hui."
        ),
        WeatherDay(
            city = "Kyoto",
            temperature = 24,
            condition = "Nuageux",
            emoji = "☁️",
            message = "Temps calme pour se promener."
        ),
        WeatherDay(
            city = "Québec",
            temperature = 18,
            condition = "Frais",
            emoji = "🌥️",
            message = "Petite laine recommandée."
        )
    )

    val todayWeather = savedLocations.first()
}