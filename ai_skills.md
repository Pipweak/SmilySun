# AI Skills — SmilySun

Ce fichier guide les IA qui travaillent sur le projet **SmilySun**.

Le but n’est pas seulement de produire du code. Le but principal est d’aider Vincent à **comprendre Android, Kotlin et Jetpack Compose étape par étape**, en gardant un projet propre, méthodique et évolutif.

---

# 1. Projet

## Nom

**SmilySun**

## Type

Application Android météo simple.

## Objectif V1

Créer une V1 Android native avec :

- Kotlin
- Jetpack Compose
- données locales/fictives
- aucune API météo
- aucun backend
- aucune géolocalisation réelle
- aucune base de données distante
- aucune publication Play Store au début

La V1 sert à apprendre les bases sans se bloquer sur le réseau, les permissions ou une architecture trop avancée.

---

# 2. Profil de Vincent

Vincent est développeur front-end avec de l’expérience web, notamment **Angular**.

Il apprend :

- Android natif
- Kotlin
- Jetpack Compose
- structure de projet Android
- bonnes pratiques progressives

Il veut comprendre ce qu’il fait. Il ne veut pas simplement copier-coller du code.

Style attendu :

- direct
- clair
- step by step
- pas de jargon inutile
- petits morceaux testables
- explication des concepts
- KDoc/Javadoc utile dans le code
- architecture propre, même si simple

---

# 3. Règle pédagogique principale

Toujours privilégier :

```txt
Comprendre > copier-coller
Simple > complexe
Méthodique > rapide
Propre > bordélique
```

Ne pas donner de gros blocs de code sans contexte, sauf si Vincent demande explicitement “donne-moi le fichier complet”.

Quand Vincent demande TLDR, répondre en TLDR.

---

# 4. Parallèles Angular utiles

L’IA peut utiliser des analogies Angular quand elles aident.

```txt
@Composable function
≈ component UI

SmilySunApp
≈ racine de l’application Compose

WeatherHomeScreen / SavedLocationsScreen
≈ pages / screen components

Modifier
≈ style/layout appliqué au composant, proche d’un mix CSS/directive

AndroidManifest.xml
≈ contrat système de l’app, pas un composant UI

MainActivity
≈ point d’entrée Android, pas l’endroit où mettre toute l’app
```

Attention : ne pas pousser l’analogie si elle devient fausse.

---

# 5. État actuel du projet

## Repo GitHub

```txt
Pipweak/SmilySun
```

## Branches

```txt
develop = branche de travail par défaut
main = branche stable / releases
```

Workflow souhaité :

```txt
travail quotidien -> develop
version stable -> merge vers main
release éventuelle -> tag depuis main
```

## Branche en cours

```txt
feat/step-3-weather-model
```

## Package actuel

```kotlin
package com.example.smilysun
```

Respecter ce package tant que Vincent ne demande pas explicitement de le renommer.

## État fonctionnel actuel

L’étape 1 est terminée.  
L’étape 2 est terminée.  
L’étape 3 est commencée.

L’app :

- compile
- lance `MainActivity`
- utilise Compose via `setContent`
- affiche un écran statique centré
- affiche `SmilySun`, `Montréal`, `☀️ 22°C`, `Ensoleillé`
- affiche un message météo statique
- a maintenant un modèle `WeatherDay`
- `HomeScreen` reçoit un `WeatherDay` en paramètre

---

# 6. Direction UX V1

Vincent a clarifié qu’il veut une V1 inspirée d’un mix entre :

- Google Weather
- MétéoMédia

Le but n’est pas de copier ces apps, mais de viser :

```txt
un écran météo principal clair
un écran Mes endroits pour gérer les villes
une navigation simple entre les deux
une interface météo visuelle et lisible
```

Document dédié :

```txt
docs/v1/ux-direction.md
```

## Écrans probables

```txt
WeatherHomeScreen
= écran météo de la ville sélectionnée

SavedLocationsScreen
= écran Mes endroits / gestion des villes
```

Important : avant de créer trop de modèles ou de repositories, réfléchir aux écrans nécessaires et aux données affichées.

---

# 7. Stratégie modèles de données

Le modèle actuel `WeatherDay` est pédagogique et temporaire.

Il sert à apprendre :

- `data class`
- `val`
- séparation données / UI
- passage d’objet à un composant Compose

Mais les modèles devront probablement évoluer selon :

```txt
1. les écrans construits
2. les données fictives nécessaires à ces écrans
3. la forme des données reçues par la future API météo
```

Modèles probables plus tard :

```txt
WeatherLocation
CurrentWeather
DailyForecast
HourlyForecast
```

Règle : ne pas over-engineer maintenant. Créer uniquement ce que les écrans exigent.

---

# 8. Architecture cible progressive

On ne veut pas empiler trop de `@Composable` dans `MainActivity.kt`.

Structure cible plus propre :

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

Responsabilités :

```txt
MainActivity
= point d’entrée Android uniquement

SmilySunApp
= racine Compose + navigation simple

WeatherHomeScreen
= météo de la ville sélectionnée

SavedLocationsScreen
= gestion/choix des villes

ui/component
= composants réutilisables

model
= data classes

data
= données locales/fictives
```

Règle :

```txt
1 écran important = 1 fichier
1 composant réutilisable important = 1 fichier
petits helpers privés = peuvent rester dans le même fichier
```

On fera le refactor quand `MainActivity.kt` commence à devenir illisible ou quand la navigation écran principal / mes endroits démarre.

---

# 9. État actuel de `MainActivity.kt`

`MainActivity.kt` contient encore `SmilySunApp` et `HomeScreen` pour apprentissage.

`HomeScreen` reçoit maintenant :

```kotlin
weather: WeatherDay
```

Cela ressemble à un input de composant côté Angular.

Cette approche est OK pour apprendre, mais elle n’est pas forcément la structure finale de l’app.

---

# 10. Règles de code

## Code minimal mais propre

Éviter :

- Clean Architecture complète trop tôt
- MVVM complet trop tôt
- DI/Hilt trop tôt
- Retrofit/Ktor trop tôt
- Room/Firebase trop tôt

Préférer :

- code simple
- noms clairs
- responsabilités séparées
- petits composants
- progression logique

## KDoc/Javadoc

Vincent aime la KDoc/Javadoc pour comprendre.

Ajouter de la KDoc utile pour les responsabilités importantes :

```kotlin
/**
 * MainActivity = point d’entrée Android.
 *
 * Cette classe est lancée par Android quand l’utilisateur ouvre l’app.
 * Elle démarre Compose avec setContent.
 */
class MainActivity : ComponentActivity() {
}
```

Pour un modèle :

```kotlin
/**
 * WeatherDay représente une journée météo dans SmilySun.
 *
 * Pour la V1, ces données sont fictives et locales.
 */
data class WeatherDay(...)
```

Ne pas commenter chaque ligne. Commenter surtout les rôles, décisions et concepts.

## Format Kotlin

One-liners acceptés pour composants simples :

```kotlin
Text(text = "SmilySun", fontSize = 32.sp)
```

Multi-line préféré quand :

- 3+ paramètres
- modifier chainé
- lambda enfant
- code trop long pour rester lisible

---

# 11. Concepts déjà clarifiés

## Jetpack Compose

Compose est le framework UI déclaratif moderne d’Android.

```txt
Kotlin = langage
Android = plateforme
Jetpack Compose = framework UI
```

## `@Composable`

Un `@Composable` est un composant UI Compose.

Mentalement :

```txt
@Composable function ≈ component UI
```

## `setContent`

`setContent` est le point d’entrée Compose dans une `Activity`.

## `Column`

`Column` place ses enfants verticalement.

## `Spacer`

`Spacer` est un composant vide utilisé pour créer de l’espace.

## `Modifier`

`Modifier` applique du layout, du style ou du comportement à un composant Compose.

## `dp`

`dp` = density-independent pixels, unité adaptée aux différentes densités d’écran Android.

## `sp`

`sp` = scale-independent pixels, unité recommandée pour les tailles de texte parce qu’elle respecte les réglages d’accessibilité de l’utilisateur.

## `val`

`val` est proche de `const` en JavaScript : valeur/propriété en lecture seule.

## `var`

`var` est proche de `let` : valeur/propriété modifiable.

## `data class`

`data class` sert à représenter des données.

## Android Manifest

Le Manifest est un contrat entre l’app et Android. Il ne déclare pas les composants Compose.

---

# 12. Points techniques connus

## Compose ajouté manuellement

Le projet n’avait pas Compose activé au départ.

Compose a été ajouté via Gradle.

Avec AGP 9+, ne pas appliquer manuellement :

```txt
org.jetbrains.kotlin.android
```

Le projet utilise le support Kotlin intégré à AGP.

## Material

Ne pas confondre :

```txt
Material Components XML
≠ Compose Material3
```

`implementation(libs.material)` a été gardé parce que le thème XML actuel dépend encore de `Theme.MaterialComponents`.

Vincent veut pouvoir créer ses propres composants. Il n’est pas obligé d’utiliser Material3 partout.

## Émulateur

Éviter les devices cloud si possible.

Préférer :

```txt
Pixel 9a
API 36 stable
Google Play
x86_64
```

Éviter les images `Pre-Release` pour l’apprentissage.

---

# 13. Roadmap pédagogique

## Étape 1 — terminée

Concepts vus :

- projet Android
- package
- Git local + GitHub repo
- branches `develop` / `main`
- AndroidManifest
- `MainActivity`
- `ComponentActivity`
- `onCreate`
- `super.onCreate`
- `setContent`
- premier `Text`
- Compose/Gradle
- émulateur local

## Étape 2 — terminée

Objectif atteint : écran statique simple.

Concepts vus :

- `SmilySunApp`
- `HomeScreen`
- `@Composable`
- `Column`
- `Text`
- `Spacer`
- `Modifier.padding`
- `Modifier.fillMaxSize`
- `Arrangement.Center`
- `Alignment.CenterHorizontally`
- `dp`
- `sp`
- KDoc de base

## Étape 3 — en cours

Objectif : créer le modèle météo `WeatherDay`, mais sans partir trop vite dans une structure de modèles finale.

Concepts vus / en cours :

- package `model`
- fichier `WeatherDay.kt`
- `data class`
- `val`
- séparation données / UI
- passage `weather: WeatherDay` à `HomeScreen`

Point d’arrêt actuel : réfléchir aux écrans et au modèle de données avant d’ajouter trop de structure.

---

# 14. Style de réponse attendu

Structure idéale :

```txt
1. Ce qu’on va faire
2. Pourquoi on le fait
3. Code minimal ou fichier complet selon la demande
4. Explication simple
5. Checkpoint
```

Quand Vincent est frustré, ne pas répéter inutilement. Reconnaître et avancer.

---

# 15. Résumé pour les IA

Quand tu travailles sur SmilySun :

```txt
Ne va pas trop vite.
Explique les concepts.
Respecte le projet réel.
Utilise Kotlin + Jetpack Compose.
Garde la V1 sans API.
Priorise la compréhension.
Garde une architecture propre.
Ajoute de la KDoc utile.
Travaille sur develop, main sert aux releases.
Étape 3 est en cours.
Ne pas figer les modèles trop tôt : ils doivent évoluer avec les écrans et la future API météo.
```
