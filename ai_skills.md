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
- aucune géolocalisation
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

HomeScreen
≈ page / screen component

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

## Package actuel

```kotlin
package com.example.smilysun
```

Respecter ce package tant que Vincent ne demande pas explicitement de le renommer.

## État fonctionnel actuel

L’étape 1 est terminée.  
L’étape 2 est terminée sur la branche feature.

L’app :

- compile
- lance `MainActivity`
- utilise Compose via `setContent`
- affiche un écran statique centré
- affiche `SmilySun`, `Montréal`, `☀️ 22°C`, `Ensoleillé`
- affiche un message météo statique

## Branche en cours

```txt
feat/etape-2-Créer-un-premier-écran-statique
```

Cette branche doit être mergée vers `develop` via PR si validation OK.

---

# 6. Architecture cible progressive

On ne veut pas empiler trop de `@Composable` dans `MainActivity.kt`.

Structure cible plus propre :

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

Responsabilités :

```txt
MainActivity
= point d’entrée Android uniquement

SmilySunApp
= racine Compose de l’app

HomeScreen
= écran principal

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

On fera le refactor quand `MainActivity.kt` commence à devenir illisible.

---

# 7. État actuel de `MainActivity.kt`

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

Pour un composant :

```kotlin
/**
 * HomeScreen = écran principal de SmilySun.
 *
 * Dans la V1, cet écran affiche une météo fictive statique.
 */
@Composable
fun HomeScreen() {
}
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

```kotlin
setContent {
    SmilySunApp()
}
```

## `Column`

`Column` place ses enfants verticalement.

## `Spacer`

`Spacer` est un composant vide utilisé pour créer de l’espace.

```kotlin
Spacer(modifier = Modifier.height(16.dp))
```

## `Modifier`

`Modifier` applique du layout, du style ou du comportement à un composant Compose.

```kotlin
Modifier
    .fillMaxSize()
    .padding(24.dp)
```

## `dp`

`dp` = density-independent pixels, unité adaptée aux différentes densités d’écran Android.

## `sp`

`sp` = scale-independent pixels, unité recommandée pour les tailles de texte parce qu’elle respecte les réglages d’accessibilité de l’utilisateur.

## Android Manifest

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

# 11. Roadmap pédagogique

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

## Étape 3 — prochaine étape

Objectif : créer le modèle météo `WeatherDay`.

Concepts à venir :

- package `model`
- fichier `WeatherDay.kt`
- `data class`
- séparation données / UI

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
Travaille sur develop, main sert aux releases.
Étape 2 est terminée; prochaine étape = WeatherDay.
```
