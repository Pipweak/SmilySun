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
- [x] Étape 3 commencée : modèle météo `WeatherDay`
- [x] Direction UX V1 clarifiée

---

# Direction produit V1

La V1 doit évoluer vers un mix simple entre :

- l’app météo de Google
- MétéoMédia

Le but n’est pas de copier ces apps. Le but est d’avoir :

```txt
un écran météo principal clair
un écran Mes endroits pour gérer les villes
une navigation simple entre les deux
une interface météo visuelle et lisible
```

Voir aussi :

```txt
docs/v1/ux-direction.md
```

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
- [ ] Afficher un écran `Mes endroits`
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

# Écrans envisagés

## WeatherHomeScreen

Écran météo principal.

Contenu envisagé progressivement :

- ville active
- température principale
- condition météo
- icône / emoji météo
- ressenti
- maximum / minimum
- message météo court
- carte d’information météo
- aperçu des prévisions horaires
- aperçu des prévisions sur quelques jours

## SavedLocationsScreen

Écran `Mes endroits`.

Contenu envisagé progressivement :

- bouton retour
- titre : `Mes endroits`
- bouton ajouter
- liste de villes sauvegardées
- ville sélectionnée / active
- température par ville
- condition météo par ville
- icône / emoji météo
- heure locale fictive ou formatée

---

# Modèles de données : note importante

Le modèle actuel `WeatherDay` est utile pour apprendre, mais il est probablement temporaire.

Les modèles devront évoluer selon :

```txt
1. les écrans construits
2. les données fictives nécessaires
3. plus tard, les données reçues par l’API météo choisie
```

Donc on garde une approche souple.

Modèles probables plus tard :

```txt
WeatherLocation
CurrentWeather
DailyForecast
HourlyForecast
```

Mais on ne crée pas tout maintenant.

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
├── MainActivity.kt
└── model/
    └── WeatherDay.kt
```

## Structure cible progressive

Quand le fichier commence à grossir, on séparera les responsabilités :

```txt
app/src/main/java/com/example/smilysun/
├── MainActivity.kt
├── ui/
│   ├── SmilySunApp.kt
│   ├── screen/
│   │   ├── WeatherHomeScreen.kt
│   │   └── SavedLocationsScreen.kt
│   └── component/
│       ├── WeatherCard.kt
│       ├── ForecastList.kt
│       ├── SavedLocationRow.kt
│       └── CitySelector.kt
├── model/
│   ├── WeatherDay.kt
│   └── WeatherLocation.kt
└── data/
    └── FakeWeatherRepository.kt
```

Règle :

```txt
MainActivity = point d’entrée Android uniquement
SmilySunApp = racine Compose + navigation simple
WeatherHomeScreen = météo de la ville sélectionnée
SavedLocationsScreen = gestion/choix des villes
component/ = composants réutilisables
model/ = data classes
data/ = données locales/fictives
```

---

# État actuel du code

## `WeatherDay.kt`

```kotlin
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
```

## `MainActivity.kt`

`HomeScreen` reçoit maintenant un objet `WeatherDay` en paramètre.

Cela permet de commencer à séparer :

```txt
données météo
interface Compose
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

---

## Étape 2 — Créer un premier écran statique

Statut : terminé.

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

---

# Étape 3 — Créer le modèle météo

Statut : en cours.

Objectif : sortir les valeurs météo de l’UI pour commencer à séparer données et affichage.

Checklist :

- [x] Créer le dossier `model`
- [x] Créer le fichier `WeatherDay.kt`
- [x] Créer une `data class WeatherDay`
- [x] Ajouter `city`
- [x] Ajouter `temperature`
- [x] Ajouter `condition`
- [x] Ajouter `emoji`
- [x] Ajouter `message`
- [x] Comprendre la différence entre `val` et `var`
- [x] Comprendre que passer `weather: WeatherDay` ressemble à un input de composant
- [x] Brancher temporairement `HomeScreen(weather = todayWeather)`
- [ ] Décider si `WeatherDay` reste le bon modèle pour la suite immédiate
- [ ] Ne pas aller trop loin dans les modèles avant de clarifier les écrans

---

# Étape 4 — Créer des données météo fictives

Statut : à venir, mais dépend de la direction modèles/écrans.

Checklist possible :

- [ ] Créer le dossier `data`
- [ ] Créer le fichier `FakeWeatherRepository.kt`
- [ ] Créer un objet `FakeWeatherRepository`
- [ ] Ajouter une météo fictive pour Montréal
- [ ] Ajouter plusieurs villes si l’écran `Mes endroits` devient prioritaire
- [ ] Comprendre le rôle d’un repository fake

---

# Étape 5 — Brancher l’interface sur les données

Statut : à venir.

Objectif :

- [ ] Ne plus écrire les valeurs météo directement dans l’UI
- [ ] Utiliser un ou plusieurs modèles météo
- [ ] Afficher les données depuis l’objet reçu
- [ ] Préparer le futur changement vers une API météo

---

# Étape 6 — Créer une carte météo

Statut : à venir.

Checklist :

- [ ] Créer le dossier `ui/component`
- [ ] Créer le fichier `WeatherCard.kt`
- [ ] Créer une fonction composable `WeatherCard`
- [ ] Passer les données nécessaires en paramètre
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

# Étape 8 — Ajouter une sélection de ville / Mes endroits

Statut : à venir.

Checklist :

- [ ] Créer plusieurs villes fictives
- [ ] Créer un écran `SavedLocationsScreen`
- [ ] Afficher les villes sauvegardées
- [ ] Ajouter Montréal
- [ ] Ajouter Tokyo
- [ ] Ajouter Kyoto
- [ ] Ajouter Québec ou autres villes
- [ ] Ajouter une sélection de ville
- [ ] Comprendre `remember`
- [ ] Comprendre `mutableStateOf`
- [ ] Changer la météo selon la ville choisie

---

# Étape 9 — Améliorer le style visuel

Statut : à venir.

Checklist :

- [ ] Choisir une direction artistique simple
- [ ] Ajouter un fond doux / gradient
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
- [ ] `ui/screen/WeatherHomeScreen.kt`
- [ ] `ui/screen/SavedLocationsScreen.kt`
- [ ] `ui/component/WeatherCard.kt`
- [ ] `ui/component/ForecastList.kt`
- [ ] `ui/component/SavedLocationRow.kt`
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
- [ ] écran météo principal
- [ ] écran `Mes endroits`
- [ ] plusieurs villes
- [ ] prévision sur 3 jours
- [ ] sélection de ville
- [ ] UI propre
- [ ] composants séparés progressivement

## V1.1 — Amélioration UX

- [ ] sauvegarder la ville préférée
- [ ] ajouter des animations / transitions
- [ ] améliorer le thème visuel
- [ ] ajouter mode clair / sombre
- [ ] ajouter plus de messages météo

## V2 — Vraie météo avec API

- [ ] choisir une API météo
- [ ] connecter une API météo
- [ ] aligner les modèles locaux avec les données reçues
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
- [x] géolocalisation réelle
- [x] notifications
- [x] publication Play Store
- [x] architecture trop complexe

Ici `[x]` veut dire : volontairement exclu de la V1.

---

# Prochaine étape

Stopper la progression technique trop rapide et clarifier la suite immédiate :

- [ ] décider si on continue avec `WeatherDay` temporairement
- [ ] décider si la prochaine priorité est `FakeWeatherRepository` ou la réflexion sur `WeatherHomeScreen` / `SavedLocationsScreen`
- [ ] garder en tête que les modèles évolueront avec les écrans et la future API météo
