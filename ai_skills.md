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

Style attendu :

- direct
- clair
- step by step
- pas de jargon inutile
- petits morceaux testables
- explication des concepts
- KDoc/Javadoc utile dans le code
- architecture propre, même si simple

Règle pédagogique principale :

```txt
Comprendre > copier-coller
Simple > complexe
Méthodique > rapide
Propre > bordélique
```

Ne pas donner de gros blocs de code sans contexte, sauf si Vincent demande explicitement “donne-moi le fichier complet”.

---

# 3. Parallèles Angular utiles

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

# 4. État actuel du projet

## Repo GitHub

```txt
Pipweak/SmilySun
```

## Branches

```txt
develop = branche de travail par défaut
main = branche stable / releases
feat/step-3-weather-model = branche en cours
```

Important : pas d’accents dans les noms de branches Git.

## Package actuel

```kotlin
package com.example.smilysun
```

Respecter ce package tant que Vincent ne demande pas explicitement de le renommer.

## État fonctionnel actuel

L’étape 1 est terminée.  
L’étape 2 est terminée.  
L’étape 3 est en cours.

L’app :

- lance `MainActivity`
- utilise Compose via `setContent`
- `MainActivity.kt` est clean et appelle seulement `SmilySunApp()`
- `SmilySunApp.kt` est la racine Compose
- `WeatherHomeScreen.kt` exporte `WeatherHomeScreen`
- `WeatherHomeScreen` reçoit un `WeatherDay` en paramètre
- `SavedLocationsScreen.kt` existe, mais n’est pas encore branché à une navigation réelle
- `WeatherDay.kt` existe comme modèle pédagogique temporaire
- `FakeWeatherRepository.kt` fournit des villes météo fictives locales

---

# 5. Direction UX V1

Vincent veut une V1 inspirée d’un mix entre :

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

---

# 6. Stratégie modèles de données

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

# 7. Architecture actuelle

```txt
app/src/main/java/com/example/smilysun/
├── MainActivity.kt
├── data/
│   └── FakeWeatherRepository.kt
├── model/
│   └── WeatherDay.kt
└── ui/
    ├── SmilySunApp.kt
    ├── component/
    │   ├── SavedLocationRow.kt
    │   └── SavedLocationsSection.kt
    └── screen/
        ├── SavedLocationsScreen.kt
        └── WeatherHomeScreen.kt
```

Responsabilités :

```txt
MainActivity
= point d’entrée Android uniquement

SmilySunApp
= racine Compose + future navigation simple

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

---

# 8. Règles de code

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

# 9. Concepts déjà clarifiés

```txt
Kotlin = langage
Android = plateforme
Jetpack Compose = framework UI
@Composable function ≈ composant UI
setContent = point d’entrée Compose dans une Activity
Column = layout vertical
Spacer = espace vide
Modifier = layout/style/comportement appliqué à un composant
val = valeur en lecture seule
var = valeur modifiable
data class = classe pour représenter des données
dp = unité Android adaptée aux densités d’écran
sp = unité recommandée pour les tailles de texte
```

Le Manifest est un contrat entre l’app et Android. Il ne déclare pas les composants Compose.

---

# 10. Points techniques connus

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

---

# 11. Roadmap pédagogique

## Étape 1 — terminée

Concepts vus : projet Android, package, Git/GitHub, branches, Manifest, `MainActivity`, `ComponentActivity`, `onCreate`, `super.onCreate`, `setContent`, premier `Text`, Compose/Gradle, émulateur local.

## Étape 2 — terminée

Objectif atteint : écran statique simple.

Concepts vus : `SmilySunApp`, écran météo principal, `@Composable`, `Column`, `Text`, `Spacer`, `Modifier.padding`, `Modifier.fillMaxSize`, `Arrangement.Center`, `Alignment.CenterHorizontally`, `dp`, `sp`, KDoc de base.

## Étape 3 — en cours

Objectif : créer le modèle météo `WeatherDay`, mais sans partir trop vite dans une structure de modèles finale.

Concepts vus / en cours :

- package `model`
- fichier `WeatherDay.kt`
- `data class`
- `val`
- séparation données / UI
- passage `weather: WeatherDay` à `WeatherHomeScreen`
- début du refactor en `ui`, `screen`, `component`, `model`, `data`

---

# 12. Style de réponse attendu

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

# 13. Résumé pour les IA

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
Travaille sur develop ou sur la branche de feature active.
main sert aux releases.
Étape 3 est en cours.
WeatherHomeScreen est le nom actuel de l’écran météo principal.
Ne pas figer les modèles trop tôt : ils doivent évoluer avec les écrans et la future API météo.
```
