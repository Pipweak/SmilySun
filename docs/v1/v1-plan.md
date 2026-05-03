# SmilySun — V1 Plan Checklist

SmilySun est une application Android météo simple créée pour apprendre le développement mobile étape par étape.

La V1 ne consomme aucune API. Elle utilise des données météo locales/fictives afin de se concentrer sur les bases : interface, composants, état, navigation simple et organisation du code.

---

# État actuel

## Branches

```txt
develop = branche de travail par défaut
main = branche stable / releases
```

## Statut global

- [x] Repo GitHub créé : `Pipweak/SmilySun`
- [x] Branche `develop` créée
- [x] Branche `develop` définie comme branche par défaut
- [x] Branche `main` réservée aux releases
- [x] Étape 1 terminée
- [x] Étape 2 terminée
- [ ] Étape 3 à commencer : modèle météo `WeatherDay`

---

# Objectif du projet

Créer une V1 simple d’une application météo Android avec :

- [x] une première interface statique
- [x] une météo du jour fictive statique
- [ ] une prévision sur quelques jours
- [ ] une sélection de ville
- [ ] une structure de code claire en fichiers séparés
- [x] aucune API externe pour commencer

---

# Stack technique

- [x] Android Studio
- [x] Kotlin
- [x] Jetpack Compose
- [x] Données locales
- [x] Pas de backend
- [x] Pas d’API pour la V1
- [x] Git local
- [x] GitHub

---

# Version actuelle visée : V1 sans API

## Fonctionnalités principales

- [x] Afficher le nom de l’application : SmilySun
- [x] Afficher une ville statique : Montréal
- [x] Afficher une température statique : 22°C
- [x] Afficher une condition météo statique : Ensoleillé
- [x] Afficher un emoji météo statique : ☀️
- [x] Afficher un petit message météo statique
- [ ] Afficher une prévision sur 3 jours
- [ ] Changer de ville avec une sélection simple

---

# Affichage actuel

```txt
SmilySun

Montréal
☀️ 22°C
Ensoleillé

Belle journée pour sortir un peu.
```

L’affichage est volontairement simple. Le but de l’étape 2 était de valider Compose, la structure de base, le layout vertical, le centrage et la lisibilité minimale.

---

# Exemple d’affichage cible V1

```txt
SmilySun

Montréal
Aujourd’hui

☀️ 22°C
Ensoleillé

Belle journée pour sortir un peu.

Prévisions :
Aujourd’hui     ☀️ 22°C
Demain          ☁️ 18°C
Après-demain    🌧️ 15°C
```

---

# Structure actuelle / cible

## Structure actuelle simplifiée

Pour apprendre, les premiers composables sont encore dans `MainActivity.kt`.

```txt
app/src/main/java/com/example/smilysun/
└── MainActivity.kt
```

## Structure cible progressive

Quand le fichier commence à grossir, on séparera les responsabilités :

```txt
app/src/main/java/com/example/smilysun/
├── MainActivity.kt
├── ui/
│   ├── SmilySunApp.kt
│   ├── screen/
│   │   └── HomeScreen.kt
│   └── component/
│       ├── WeatherCard.kt
│       ├── ForecastList.kt
│       └── CitySelector.kt
├── model/
│   └── WeatherDay.kt
└── data/
    └── FakeWeatherRepository.kt
```

Règle :

```txt
MainActivity = point d’entrée Android uniquement
SmilySunApp = racine Compose
HomeScreen = écran principal
component/ = composants réutilisables
model/ = data classes
data/ = données locales/fictives
```

---

# État actuel du code

## `MainActivity.kt`

```kotlin
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
    HomeScreen()
}

/**
 * HomeScreen = écran principal de SmilySun.
 *
 * Dans la V1, cet écran affiche une météo fictive statique.
 */
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SmilySun", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Montréal", fontSize = 20.sp)
        Text(text = "☀️ 22°C", fontSize = 40.sp)
        Text(text = "Ensoleillé", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Belle journée pour sortir un peu.", fontSize = 16.sp)
    }
}
```

---

# Plan de développement

## Étape 1 — Créer le projet Android

Statut : terminé.

### Checklist Étape 1

- [x] Ouvrir Android Studio
- [x] Créer le projet `SmilySun`
- [x] Utiliser Kotlin
- [x] Ajouter Jetpack Compose manuellement via Gradle
- [x] Attendre que Gradle Sync se termine
- [x] Vérifier le package réel du projet : `com.example.smilysun`
- [x] Vérifier que `MainActivity.kt` existe
- [x] Vérifier que `AndroidManifest.xml` existe
- [x] Transformer `MainActivity` en vraie Activity Android
- [x] Déclarer `MainActivity` dans le Manifest
- [x] Ajouter `MAIN` dans l’`intent-filter`
- [x] Ajouter `LAUNCHER` dans l’`intent-filter`
- [x] Ajouter `onCreate` dans `MainActivity`
- [x] Ajouter `setContent`
- [x] Afficher un premier `Text("SmilySun")`
- [x] Créer un émulateur local stable
- [x] Lancer l’app
- [x] Vérifier que l’écran affiche `SmilySun`

### Concepts vus

- projet Android
- package
- `AndroidManifest.xml`
- `<manifest>`
- `<application>`
- `<activity>`
- `MAIN`
- `LAUNCHER`
- `MainActivity`
- `ComponentActivity`
- `onCreate`
- `super.onCreate`
- `setContent`
- `Text`
- Compose dans Gradle
- émulateur local vs device cloud

---

## Étape 2 — Créer un premier écran statique

Statut : terminé.

### Objectif

Créer une interface très simple avec :

- [x] le titre `SmilySun`
- [x] une ville : `Montréal`
- [x] une température : `22°C`
- [x] une condition météo : `Ensoleillé`
- [x] un emoji météo : `☀️`
- [x] un message météo statique
- [x] un layout vertical simple
- [x] une interface centrée
- [x] une typographie minimale plus lisible

### Checklist Étape 2

- [x] Créer une fonction `SmilySunApp`
- [x] Déplacer l’appel UI dans `SmilySunApp`
- [x] Ajouter l’import `@Composable`
- [x] Remplacer `Text("SmilySun")` dans `setContent` par `SmilySunApp()`
- [x] Créer une fonction `HomeScreen`
- [x] Faire appeler `HomeScreen()` par `SmilySunApp()`
- [x] Ajouter une `Column`
- [x] Mettre les textes les uns sous les autres
- [x] Afficher `SmilySun`
- [x] Afficher `Montréal`
- [x] Afficher `☀️ 22°C`
- [x] Afficher `Ensoleillé`
- [x] Afficher un message météo statique
- [x] Ajouter `Modifier.padding(24.dp)`
- [x] Ajouter `fillMaxSize()`
- [x] Ajouter `verticalArrangement = Arrangement.Center`
- [x] Ajouter `horizontalAlignment = Alignment.CenterHorizontally`
- [x] Ajouter des tailles de texte avec `fontSize`
- [x] Ajouter des `Spacer`
- [x] Ajouter de la KDoc simple sur `MainActivity`, `SmilySunApp`, `HomeScreen`
- [x] Lancer l’app après ces changements
- [x] Vérifier que l’écran statique s’affiche correctement

### Concepts appris dans l’étape 2

- [x] `@Composable`
- [x] `Column`
- [x] `Text`
- [x] `Spacer`
- [x] `Modifier`
- [x] `padding`
- [x] `height`
- [x] `dp`
- [x] `sp`
- [x] `fillMaxSize`
- [x] `fontSize`
- [x] `verticalArrangement`
- [x] `horizontalAlignment`
- [x] KDoc simple sur les responsabilités

---

# Étape 3 — Créer le modèle météo

Statut : prochaine étape.

Objectif : sortir les valeurs météo de l’UI pour commencer à séparer données et affichage.

Checklist :

- [ ] Créer le dossier `model`
- [ ] Créer le fichier `WeatherDay.kt`
- [ ] Créer une `data class WeatherDay`
- [ ] Ajouter `city`
- [ ] Ajouter `temperature`
- [ ] Ajouter `condition`
- [ ] Ajouter `emoji`
- [ ] Ajouter `message`
- [ ] Comprendre la différence entre données et UI

Code cible :

```kotlin
data class WeatherDay(
    val city: String,
    val temperature: Int,
    val condition: String,
    val emoji: String,
    val message: String
)
```

---

# Étape 4 — Créer des données météo fictives

Statut : à venir.

Checklist :

- [ ] Créer le dossier `data`
- [ ] Créer le fichier `FakeWeatherRepository.kt`
- [ ] Créer un objet `FakeWeatherRepository`
- [ ] Ajouter une météo fictive pour Montréal
- [ ] Comprendre le rôle d’un repository fake

---

# Étape 5 — Brancher l’interface sur les données

Statut : à venir.

Objectif :

- [ ] Ne plus écrire les valeurs météo directement dans l’UI
- [ ] Utiliser un objet `WeatherDay`
- [ ] Afficher `weather.temperature`
- [ ] Afficher `weather.city`
- [ ] Afficher `weather.condition`
- [ ] Afficher `weather.emoji`
- [ ] Afficher `weather.message`

---

# Étape 6 — Créer une carte météo

Statut : à venir.

Checklist :

- [ ] Créer le dossier `ui/component`
- [ ] Créer le fichier `WeatherCard.kt`
- [ ] Créer une fonction composable `WeatherCard`
- [ ] Passer `weather` en paramètre
- [ ] Afficher l’emoji météo
- [ ] Afficher la température
- [ ] Afficher la condition
- [ ] Afficher le message
- [ ] Comprendre les composants réutilisables

---

# Étape 7 — Ajouter une prévision sur 3 jours

Statut : à venir.

Checklist :

- [ ] Créer une liste `forecast`
- [ ] Ajouter 3 journées météo
- [ ] Afficher la liste
- [ ] Créer `ForecastList`
- [ ] Créer `ForecastItem`
- [ ] Comprendre `listOf`
- [ ] Comprendre l’affichage d’une liste

---

# Étape 8 — Ajouter une sélection de ville

Statut : à venir.

Checklist :

- [ ] Créer plusieurs villes fictives
- [ ] Créer `weatherByCity`
- [ ] Ajouter Montréal
- [ ] Ajouter Tokyo
- [ ] Ajouter Sapporo
- [ ] Ajouter Paris
- [ ] Ajouter des boutons de sélection
- [ ] Comprendre `remember`
- [ ] Comprendre `mutableStateOf`
- [ ] Changer la météo selon la ville choisie

---

# Étape 9 — Améliorer le style visuel

Statut : à venir.

Checklist :

- [ ] Choisir une direction artistique simple
- [ ] Ajouter un fond doux
- [ ] Ajouter une carte météo arrondie
- [ ] Améliorer la typographie
- [ ] Ajouter des couleurs selon la météo
- [ ] Garder une interface lisible

---

# Étape 10 — Ajouter une mini animation

Statut : à venir.

Checklist :

- [ ] Faire bouger légèrement le soleil
- [ ] Faire apparaître la carte météo doucement
- [ ] Tester une animation simple
- [ ] Garder le code compréhensible
- [ ] Ne pas complexifier trop tôt

---

# Étape 11 — Nettoyer le code

Statut : à venir.

Objectif : séparer progressivement le code en plusieurs fichiers.

Checklist :

- [ ] `MainActivity.kt` contient seulement le point d’entrée Android
- [ ] `ui/SmilySunApp.kt`
- [ ] `ui/screen/HomeScreen.kt`
- [ ] `ui/component/WeatherCard.kt`
- [ ] `ui/component/ForecastList.kt`
- [ ] `ui/component/ForecastItem.kt`
- [ ] `ui/component/CitySelector.kt`
- [ ] `model/WeatherDay.kt`
- [ ] `data/FakeWeatherRepository.kt`

---

# Roadmap

## V0 — Prototype simple

- [x] écran statique minimal
- [x] titre SmilySun
- [x] météo fictive statique
- [x] température fictive statique
- [x] condition météo fictive statique
- [x] message météo statique

## V1 — Version locale complète

- [ ] données météo locales
- [ ] plusieurs villes
- [ ] prévision sur 3 jours
- [ ] sélection de ville
- [ ] UI propre
- [ ] composants séparés

## V1.1 — Amélioration UX

- [ ] sauvegarder la ville préférée
- [ ] ajouter des animations
- [ ] améliorer le thème visuel
- [ ] ajouter mode clair / sombre
- [ ] ajouter plus de messages météo

## V2 — Vraie météo avec API

- [ ] connecter une API météo
- [ ] récupérer la météo réelle
- [ ] gérer le chargement
- [ ] gérer les erreurs
- [ ] gérer la localisation
- [ ] remplacer les données fictives par des données réelles

---

# Ce qu’on évite dans la V1

Pour garder le projet simple, on évite au début :

- [x] API météo
- [x] backend
- [x] login
- [x] base de données distante
- [x] géolocalisation
- [x] notifications
- [x] publication Play Store
- [x] architecture trop complexe

Ici `[x]` veut dire : volontairement exclu de la V1.

---

# Prochaine étape

Commencer l’étape 3 :

- [ ] créer `model/WeatherDay.kt`
- [ ] définir une `data class WeatherDay`
- [ ] préparer la séparation entre données et interface
