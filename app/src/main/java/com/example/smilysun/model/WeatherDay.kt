package com.example.smilysun.model

/**
 * WeatherDay représente une journée météo dans SmilySun.
 *
 * Pour la V1, ces données seront fictives et locales.
 * Plus tard, ce modèle pourra aussi servir à représenter une météo venant d’une API.
 */
data class WeatherDay(
    val city: String,
    val temperature: Int,
    val condition: String,
    val emoji: String,
    val message: String
)