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
- [x] Étape 2 commencée

---

# Objectif du projet

Créer une V1 simple d’une application météo Android avec :

- [ ] une interface propre
- [ ] une météo du jour fictive
- [ ] une prévision sur quelques jours
- [ ] une sélection de ville
- [ ] une structure de code claire
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
- [ ] Afficher un petit message météo
- [ ] Afficher une prévision sur 3 jours
- [ ] Changer de ville avec une sélection simple

---

# Exemple d’affichage cible

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

Statut : en cours.

### Objectif

Créer une interface très simple avec :

- [x] le titre `SmilySun`
- [x] une ville : `Montréal`
- [x] une température : `22°C`
- [x] une condition météo : `Ensoleillé`
- [x] un emoji météo : `☀️`
- [ ] un layout un peu plus propre
- [ ] une interface centrée
- [ ] une typographie plus lisible

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
- [x] Ajouter un premier `Modifier.padding(24.dp)`
- [x] Ajouter de la KDoc simple sur `MainActivity`, `SmilySunApp`, `HomeScreen`
- [ ] Ajouter `fillMaxSize()`
- [ ] Ajouter `verticalArrangement = Arrangement.Center`
- [ ] Ajouter `horizontalAlignment = Alignment.CenterHorizontally`
- [ ] Ajouter des tailles de texte avec `fontSize`
- [ ] Lancer l’app après ces changements
- [ ] Vérifier que l’écran statique s’affiche correctement

### Concepts à apprendre / en cours

- [x] `@Composable`
- [x] `Column`
- [x] `Text`
- [x] `Modifier`
- [x] `padding`
- [x] `dp`
- [ ] `fillMaxSize`
- [ ] `fontSize`
- [ ] `verticalArrangement`
- [ ] `horizontalAlignment`

### Prochaine mini-étape

Centrer proprement l’écran :

```kotlin
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("SmilySun")
    Text("Montréal")
    Text("☀️ 22°C")
    Text("Ensoleillé")
}
```

---

# Étape 3 — Créer le modèle météo

Statut : à venir.

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

Continuer l’étape 2 :

- [ ] centrer l’écran avec `fillMaxSize`, `Arrangement.Center`, `Alignment.CenterHorizontally`
- [ ] ajouter des tailles de texte avec `fontSize`
- [ ] vérifier que le fichier reste lisible
- [ ] prévoir le futur refactor en fichiers séparés quand nécessaire
