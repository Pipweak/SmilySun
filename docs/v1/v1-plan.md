# SmilySun — V1 Plan Checklist

SmilySun est une petite application Android météo créée pour apprendre le développement mobile étape par étape.

La première version ne consomme aucune API.  
Elle utilise des données météo locales/fictives afin de se concentrer sur les bases : interface, composants, état, navigation simple et organisation du code.

---

## Objectif du projet

Créer une V1 simple d’une application météo Android avec :

- [ ] une interface propre
- [ ] une météo du jour fictive
- [ ] une prévision sur quelques jours
- [ ] une sélection de ville
- [ ] une structure de code claire
- [x] aucune API externe pour commencer

---

## Stack technique

- [x] Android Studio
- [x] Kotlin
- [x] Jetpack Compose
- [x] Données locales
- [x] Pas de backend
- [x] Pas d’API pour la V1

---

## Version actuelle visée : V1 sans API

### Fonctionnalités principales

- [x] Afficher le nom de l’application : SmilySun
- [ ] Afficher une ville sélectionnée
- [ ] Afficher la météo actuelle fictive
- [ ] Afficher une température
- [ ] Afficher une condition météo
- [ ] Afficher un emoji ou une icône météo
- [ ] Afficher un petit message météo
- [ ] Afficher une prévision sur 3 jours
- [ ] Changer de ville avec une sélection simple

---

## Exemple d’affichage cible

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

## Structure recommandée du projet

```txt
app/
 └── src/
     └── main/
         └── java/com/example/smilysun/
             ├── MainActivity.kt
             ├── model/
             │   └── WeatherDay.kt
             ├── data/
             │   └── FakeWeatherRepository.kt
             ├── ui/
             │   ├── HomeScreen.kt
             │   ├── WeatherCard.kt
             │   ├── ForecastList.kt
             │   ├── ForecastItem.kt
             │   └── CitySelector.kt
             └── theme/
                 └── Theme.kt
```

Note : dans ton projet actuel, le package est :

```kotlin
package com.example.smilysun
```

---

# Plan de développement

## Étape 1 — Créer le projet Android

### Objectif

Créer le projet Android, vérifier les fichiers importants, déclarer `MainActivity` et préparer le point d’entrée de l’app.

### Checklist Étape 1

- [x] Ouvrir Android Studio
- [x] Créer le projet `SmilySun`
- [x] Utiliser Kotlin
- [x] Utiliser Jetpack Compose
- [x] Attendre que Gradle Sync se termine
- [x] Vérifier le package réel du projet
- [x] Vérifier que `MainActivity.kt` existe
- [x] Vérifier que `AndroidManifest.xml` existe
- [x] Transformer `MainActivity` en vraie Activity Android
- [x] Déclarer `MainActivity` dans le Manifest
- [x] Ajouter `MAIN` dans l’`intent-filter`
- [x] Ajouter `LAUNCHER` dans l’`intent-filter`
- [x] Ajouter `onCreate` dans `MainActivity`
- [x] Ajouter `setContent`
- [x] Afficher un premier `Text("SmilySun")`
- [x] Lancer l’app
- [x] Vérifier que l’écran affiche `SmilySun`

---

### Notes importantes de l’étape 1

#### MainActivity minimale validée

```kotlin
package com.example.smilysun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text("SmilySun")
        }
    }
}
```

#### Manifest validé

```xml
<activity
    android:name=".MainActivity"
    android:exported="true">

    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>

</activity>
```

À retenir :

```txt
MAIN
= cette Activity est le point d’entrée principal

LAUNCHER
= cette Activity peut être lancée depuis l’icône de l’app
```

#### Compose ajouté manuellement

Le projet n’avait pas Compose configuré au départ.  
Compose a été ajouté via Gradle.

À retenir :

```txt
setContent
= point d’entrée Compose dans une Activity Android
```

---

## Checkpoint Étape 1

L’étape 1 est terminée.

- [x] Le projet compile
- [x] Android sait lancer `MainActivity`
- [x] `MainActivity` contient `onCreate`
- [x] `setContent` affiche quelque chose
- [x] L’app démarre sur émulateur ou téléphone
- [x] Le texte `SmilySun` apparaît à l’écran

---

# Étape 2 — Créer un premier écran statique

## Objectif

Créer une interface très simple avec :

- [ ] le titre `SmilySun`
- [ ] une ville
- [ ] une température
- [ ] une condition météo
- [ ] un emoji météo

Exemple :

```txt
SmilySun

Montréal
☀️ 22°C
Ensoleillé
```

---

## Checklist Étape 2

- [ ] Créer une fonction `SmilySunApp`
- [ ] Déplacer `Text("SmilySun")` dans `SmilySunApp`
- [ ] Ajouter l’import `@Composable`
- [ ] Remplacer `Text("SmilySun")` dans `setContent` par `SmilySunApp()`
- [ ] Ajouter une `Column`
- [ ] Mettre les textes les uns sous les autres
- [ ] Afficher `SmilySun`
- [ ] Afficher `Montréal`
- [ ] Afficher `☀️ 22°C`
- [ ] Afficher `Ensoleillé`
- [ ] Ajouter un peu de padding
- [ ] Centrer l’interface
- [ ] Lancer l’app
- [ ] Vérifier que l’écran statique s’affiche correctement

---

## Concepts à apprendre dans l’étape 2

- [ ] `@Composable`
- [ ] `Column`
- [ ] `Text`
- [ ] `Modifier`
- [ ] `padding`
- [ ] `fontSize`
- [ ] `verticalArrangement`
- [ ] `horizontalAlignment`

---

## Prochaine mini-étape

Créer une fonction Compose :

```kotlin
@Composable
fun SmilySunApp() {
    Text("SmilySun")
}
```

Puis remplacer :

```kotlin
setContent {
    Text("SmilySun")
}
```

par :

```kotlin
setContent {
    SmilySunApp()
}
```

Objectif :

```txt
setContent garde seulement le point d’entrée Compose.
SmilySunApp devient le premier composant d’écran.
```

---

# Étape 3 — Créer le modèle météo

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

Checklist :

- [ ] Créer le dossier `data`
- [ ] Créer le fichier `FakeWeatherRepository.kt`
- [ ] Créer un objet `FakeWeatherRepository`
- [ ] Ajouter une météo fictive pour Montréal
- [ ] Comprendre le rôle d’un repository fake

---

# Étape 5 — Brancher l’interface sur les données

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

Checklist :

- [ ] Créer le dossier `ui`
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

Checklist :

- [ ] Choisir une direction artistique simple
- [ ] Ajouter un fond doux
- [ ] Ajouter une carte météo arrondie
- [ ] Améliorer la typographie
- [ ] Ajouter des couleurs selon la météo
- [ ] Garder une interface lisible

---

# Étape 10 — Ajouter une mini animation

Checklist :

- [ ] Faire bouger légèrement le soleil
- [ ] Faire apparaître la carte météo doucement
- [ ] Tester une animation simple
- [ ] Garder le code compréhensible
- [ ] Ne pas complexifier trop tôt

---

# Étape 11 — Nettoyer le code

Séparer progressivement le code en plusieurs fichiers :

- [ ] `MainActivity.kt`
- [ ] `HomeScreen.kt`
- [ ] `WeatherCard.kt`
- [ ] `ForecastList.kt`
- [ ] `ForecastItem.kt`
- [ ] `CitySelector.kt`
- [ ] `WeatherDay.kt`
- [ ] `FakeWeatherRepository.kt`

---

# Étape 12 — Mettre le projet sur GitHub

Checklist :

- [ ] Créer un repo GitHub `smilysun`
- [ ] Ajouter le code source
- [ ] Ajouter le README
- [ ] Ajouter `v1-plan.md`
- [ ] Ajouter `ai_skills.md`
- [ ] Ajouter `docs/learning`
- [ ] Ajouter éventuellement des screenshots
- [ ] Écrire une courte description du projet
- [ ] Faire un premier commit propre

---

# Roadmap

## V0 — Prototype simple

- [x] écran statique minimal
- [x] titre SmilySun
- [ ] météo fictive
- [ ] température fictive
- [ ] condition météo fictive

---

## V1 — Version locale complète

- [ ] données météo locales
- [ ] plusieurs villes
- [ ] prévision sur 3 jours
- [ ] sélection de ville
- [ ] UI propre
- [ ] composants séparés

---

## V1.1 — Amélioration UX

- [ ] sauvegarder la ville préférée
- [ ] ajouter des animations
- [ ] améliorer le thème visuel
- [ ] ajouter mode clair / sombre
- [ ] ajouter plus de messages météo

---

## V2 — Vraie météo avec API

- [ ] connecter une API météo
- [ ] récupérer la météo réelle
- [ ] gérer le chargement
- [ ] gérer les erreurs
- [ ] gérer la localisation
- [ ] remplacer les données fictives par des données réelles

APIs possibles plus tard :

- [ ] Open-Meteo
- [ ] WeatherAPI
- [ ] Tomorrow.io
- [ ] Meteomatics

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

# Résumé

SmilySun V1 est une application Android météo simple, construite avec Kotlin et Jetpack Compose.

La V1 utilise uniquement des données locales fictives afin d’apprendre les bases du développement Android sans se bloquer sur les APIs, les permissions ou le backend.

Objectif final de la V1 :

```txt
Une app météo locale simple
Une interface propre
Plusieurs villes
Une prévision sur 3 jours
Aucune API
Un projet bien organisé
```

---

# Prochaine étape

Commencer l’étape 2 :

- [ ] Créer une fonction `SmilySunApp`
- [ ] Déplacer `Text("SmilySun")` dans `SmilySunApp`
- [ ] Utiliser une `Column`
- [ ] Afficher `SmilySun`
- [ ] Afficher `Montréal`
- [ ] Afficher `☀️ 22°C`
- [ ] Afficher `Ensoleillé`
