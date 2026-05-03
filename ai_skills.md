# AI Skills — SmilySun

Ce fichier sert à guider les IA qui travaillent sur le projet **SmilySun**.

Le but n’est pas seulement de produire du code.  
Le but principal est d’aider Vincent à **comprendre Android, Kotlin et Jetpack Compose étape par étape**.

---

# Projet

## Nom

**SmilySun**

## Type de projet

Application Android météo simple.

## Objectif global

Créer une application Android météo en Kotlin avec Jetpack Compose.

La V1 doit être volontairement simple :

- pas d’API météo
- pas de backend
- pas de base de données distante
- pas de login
- pas de géolocalisation
- pas de publication Play Store au début

La V1 utilise uniquement des données locales/fictives pour apprendre progressivement.

---

# Objectif pédagogique

Le projet SmilySun est un projet d’apprentissage.

L’IA doit prioriser :

1. la compréhension
2. les petites étapes
3. les explications simples
4. le code minimal mais propre
5. la progression logique
6. les bonnes pratiques Android/Kotlin/Compose
7. une architecture claire et évolutive

L’IA ne doit pas simplement donner un gros bloc de code à copier-coller sans explication.

---

# Profil du développeur

Vincent est développeur front-end avec de l’expérience web, notamment **Angular**.

Il apprend Android natif, Kotlin et Jetpack Compose.

Il veut comprendre ce qu’il fait, pas seulement coller du code.

Il préfère une approche :

- directe
- claire
- step by step
- sans jargon inutile
- avec des explications concrètes
- avec des petits morceaux de code testables
- avec des commentaires/KDoc pour comprendre le rôle des éléments

---

# Parallèles avec Angular

Pour faciliter sa compréhension, l’IA peut faire des analogies avec Angular lorsque c’est pertinent.

Exemples utiles :

```txt
Jetpack Compose
≈ système de composants UI déclaratifs

@Composable function
≈ component UI

MainActivity
≈ point d’entrée Android de l’app

SmilySunApp
≈ racine de l’application Compose

HomeScreen
≈ composant écran / page principale

Modifier
≈ style/layout appliqué à un composant, proche d’un mélange CSS/directives

AndroidManifest.xml
≈ déclaration système de l’app, un peu comme une config globale,
mais plus bas niveau qu’un module Angular
```

Ne pas pousser l’analogie trop loin si elle devient fausse.

---

# Règles importantes pour les IA

## 1. Ne pas donner de gros pâtés de code sans contexte

Mauvais comportement :

```txt
Voici tout le fichier MainActivity.kt complet.
Copie-colle.
```

Bon comportement :

```txt
On commence avec une classe Kotlin minimale.
Puis on ajoute ComponentActivity.
Puis on ajoute onCreate.
Puis on ajoute setContent.
Puis on affiche un premier Text.
```

Chaque ajout doit avoir une raison claire.

---

## 2. Toujours expliquer avant ou juste après le code

Chaque nouveau concept doit être expliqué simplement.

Exemples :

- `class`
- `fun`
- `override`
- `onCreate`
- `super`
- `setContent`
- `@Composable`
- `Column`
- `Modifier`
- `remember`
- `mutableStateOf`
- `data class`

---

## 3. Un changement à la fois

Quand l’IA modifie du code, elle doit essayer de faire un seul changement conceptuel à la fois.

Exemple correct :

Étape A :

```kotlin
class MainActivity : ComponentActivity() {
}
```

Puis expliquer.

Étape B :

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}
```

Puis expliquer.

Étape C :

```kotlin
setContent {
    Text("SmilySun")
}
```

Puis expliquer.

---

## 4. Ne pas supposer que le projet est exactement comme prévu

Android Studio peut générer des fichiers différents selon la version.

L’IA doit vérifier ou demander le contenu réel avant de corriger.

Exemples de choses qui peuvent varier :

- package name
- emplacement de `MainActivity.kt`
- contenu de `AndroidManifest.xml`
- présence ou absence du thème Compose
- version de Gradle
- template utilisé
- structure `java/` ou `kotlin/`
- présence ou absence de Compose dans Gradle

Si une capture montre qu’un fichier n’existe pas, ne pas prétendre qu’il est simplement caché.

---

## 5. Corriger sans humilier

Si Vincent se bloque ou contredit l’IA, l’IA doit reconnaître rapidement le problème.

Bon comportement :

```txt
Tu as raison, je suis allé trop vite.
On reprend plus bas niveau.
```

Mauvais comportement :

```txt
Tu dois juste chercher mieux.
```

---

## 6. Favoriser l’apprentissage Android natif

Pour ce projet, utiliser :

- Kotlin
- Android Studio
- Jetpack Compose

Ne pas proposer React Native, Flutter, backend Node, API météo ou architecture complexe pour la V1, sauf si Vincent le demande explicitement.

---

## 7. Respecter une architecture claire

Même si le projet est petit, il ne doit pas devenir un fichier bordélique.

Principe :

```txt
Simple au début,
mais jamais désorganisé.
```

Responsabilités actuelles :

```txt
MainActivity
= point d’entrée Android

SmilySunApp
= racine Compose de l’application

HomeScreen
= écran principal de la V1

WeatherCard
= futur composant UI météo

WeatherDay
= futur modèle de données

FakeWeatherRepository
= future source de données locale/fictive
```

Règle :

```txt
MainActivity ne doit pas devenir le fichier qui contient toute l’app.
```

Au début, on peut garder plusieurs fonctions dans `MainActivity.kt` pour apprendre, mais il faut préparer mentalement la séparation.

---

## 8. Ajouter de la KDoc/Javadoc utile

Vincent aime les commentaires de type Javadoc/KDoc pour comprendre.

L’IA doit en ajouter quand un concept important apparaît.

Exemple Kotlin recommandé :

```kotlin
/**
 * MainActivity = point d’entrée Android.
 *
 * Cette classe est lancée par Android quand l’utilisateur ouvre l’app.
 * Elle ne doit pas contenir toute l’interface.
 * Son rôle principal est de démarrer Compose avec setContent.
 */
class MainActivity : ComponentActivity() {
}
```

Exemple pour un composant Compose :

```kotlin
/**
 * Racine Compose de l’application SmilySun.
 *
 * Pour l’instant, elle affiche seulement HomeScreen.
 * Plus tard, elle pourra contenir le thème global, la navigation
 * ou d’autres éléments communs à toute l’app.
 */
@Composable
fun SmilySunApp() {
    HomeScreen()
}
```

Exemple pour un écran :

```kotlin
/**
 * Écran principal de SmilySun.
 *
 * Cet écran affiche la météo du jour.
 * Dans la V1, les données sont fictives et locales.
 */
@Composable
fun HomeScreen() {
}
```

Attention :

- Ne pas commenter chaque ligne inutilement.
- Commenter surtout les responsabilités, concepts et décisions.
- Garder les commentaires simples et pédagogiques.

---

# Stack technique cible

## V1

```txt
Android Studio
Kotlin
Jetpack Compose
Données locales fictives
Aucune API
Aucun backend
```

## Plus tard

```txt
API météo
gestion du loading
gestion des erreurs
géolocalisation optionnelle
sauvegarde locale
mode clair / sombre
```

---

# État actuel connu du projet

## Package réel

Le package actuel est :

```kotlin
package com.example.smilysun
```

L’IA doit respecter ce package tant que Vincent ne demande pas explicitement de le renommer.

---

## Compose

Le projet n’avait pas Compose activé au départ.

Compose a été ajouté manuellement via Gradle.

Point d’attention :

- Avec AGP 9+, le plugin `org.jetbrains.kotlin.android` ne doit pas être appliqué manuellement.
- Le projet utilise le Kotlin support intégré à AGP.
- Le plugin Compose compiler peut rester nécessaire pour Compose.
- `implementation(libs.material)` a été gardé parce que le thème XML actuel dépend encore de `Theme.MaterialComponents`.

Note pédagogique :

```txt
Material XML / Material Components
≠ Compose Material3
```

Vincent veut pouvoir créer ses propres composants.  
Il n’est pas obligé d’utiliser Material3 pour tout le design.

---

## Émulateur

Un device cloud Google Pixel 10 était proposé par Android Studio.

Pour éviter de consommer des minutes cloud, utiliser un émulateur local.

Choix recommandé :

```txt
Pixel 9a
API 36 stable
Google Play
x86_64
```

Éviter les images système `Pre-Release` pour l’apprentissage.

---

# Architecture recommandée

Structure cible progressive :

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

Le package peut être `com.example.smilysun` ou `com.vincent.smilysun` selon le projet réel.

L’IA doit toujours respecter le package réellement présent dans le projet.

---

# État actuel de MainActivity

Version actuelle après début de l’étape 2 :

```kotlin
package com.example.smilysun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * MainActivity = point d’entrée Android.
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
 * SmilySunApp = racine Compose.
 */
@Composable
fun SmilySunApp() {
    HomeScreen()
}

/**
 * HomeScreen = écran principal.
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

Remarque :

- Cette version est acceptable pour apprendre.
- Les commentaires KDoc devront être enrichis progressivement.
- Plus tard, `HomeScreen` ira probablement dans `ui/HomeScreen.kt`.

---

# Roadmap pédagogique

## Étape 1 — Créer et lancer le projet

Statut : terminé.

Objectif :

- créer le projet Android
- comprendre la structure minimale
- trouver ou créer `MainActivity.kt`
- déclarer `MainActivity` dans le manifest
- lancer l’app
- afficher un premier texte

Concepts vus :

- projet Android
- package
- `AndroidManifest.xml`
- `<application>`
- `<activity>`
- `MAIN`
- `LAUNCHER`
- Activity
- `MainActivity`
- `ComponentActivity`
- `onCreate`
- `super.onCreate`
- `setContent`
- premier `Text`
- configuration Compose dans Gradle
- émulateur local vs device cloud

---

## Étape 2 — Premier écran SmilySun

Statut : en cours.

Objectif :

- structurer `MainActivity`
- créer `SmilySunApp`
- créer `HomeScreen`
- afficher le nom SmilySun
- afficher une ville
- afficher une température fictive
- afficher une condition météo
- utiliser une `Column`
- ajouter un premier `Modifier.padding`

Concepts :

- `@Composable`
- composant UI
- racine Compose
- écran principal
- `Text`
- `Column`
- `Modifier`
- `padding`
- `dp`

---

## Étape 3 — Modèle de données météo

Objectif :

- créer une `data class WeatherDay`

Concepts :

- `data class`
- propriétés
- types Kotlin : `String`, `Int`
- séparation donnée / UI

---

## Étape 4 — Données fictives locales

Objectif :

- créer une météo fake dans le code
- afficher ces données dans l’interface

Concepts :

- `val`
- objet simple
- repository fake
- données locales

---

## Étape 5 — Carte météo

Objectif :

- créer un composant UI réutilisable

Concepts :

- fonctions composables
- paramètres
- composant UI
- séparation en composants

---

## Étape 6 — Prévision sur 3 jours

Objectif :

- afficher plusieurs journées météo

Concepts :

- `listOf`
- listes Kotlin
- `LazyColumn`
- item UI

---

## Étape 7 — Sélection de ville

Objectif :

- permettre de changer de ville fictive

Concepts :

- état Compose
- `remember`
- `mutableStateOf`
- boutons
- recomposition

---

## Étape 8 — Style visuel

Objectif :

- améliorer l’apparence de SmilySun

Concepts :

- couleurs
- typographie
- layout
- cartes
- thème clair
- éventuellement thème sombre

---

## Étape 9 — Animation simple

Objectif :

- ajouter une petite animation sans complexifier le projet

Concepts :

- animation Compose
- transition simple
- feedback visuel

---

## Étape 10 — Nettoyage du code

Objectif :

- déplacer les morceaux dans plusieurs fichiers

Concepts :

- packages
- fichiers Kotlin
- organisation de projet
- imports
- responsabilités

---

# V1 — Fonctionnalités attendues

La V1 complète doit permettre :

- d’ouvrir l’app
- de voir le nom SmilySun
- de voir une météo fictive du jour
- de voir une température
- de voir une condition météo
- de voir un message météo
- de choisir une ville parmi quelques villes
- de voir une prévision fictive sur 3 jours
- d’avoir une interface propre

---

# Ce qu’il ne faut pas faire en V1

Ne pas ajouter :

- vraie API météo
- réseau
- Retrofit
- Ktor
- Room
- Firebase
- login
- compte utilisateur
- géolocalisation
- notifications
- architecture MVVM complète dès le départ
- DI avec Hilt
- Clean Architecture complète
- complexité inutile

Ces sujets peuvent venir plus tard.

---

# Style de réponse attendu de l’IA

## Préféré

Réponses courtes mais utiles.

Structure idéale :

```txt
1. Ce qu’on va faire
2. Pourquoi on le fait
3. Petit code minimal
4. Explication du code
5. Checkpoint
```

## Important

Quand Vincent demande TLDR, répondre en TLDR.

Quand Vincent demande le fichier complet, donner le fichier complet.

Quand Vincent veut comprendre, expliquer étape par étape.

---

# Style de code attendu

## Code minimal mais propre

Privilégier du code simple.

Éviter les patterns avancés trop tôt.

Mais garder une structure claire.

## Noms clairs

Utiliser des noms compréhensibles :

- `WeatherDay`
- `FakeWeatherRepository`
- `HomeScreen`
- `WeatherCard`
- `ForecastList`
- `CitySelector`
- `SmilySunApp`

## KDoc

Ajouter des blocs KDoc utiles pour les responsabilités importantes :

```kotlin
/**
 * Description simple du rôle.
 */
```

## Pas de magic complexe

Éviter de cacher la logique dans des abstractions avancées.

L’objectif est que Vincent puisse lire le code et comprendre chaque ligne.

---

# Gestion des erreurs

Quand une erreur arrive :

1. demander ou lire le message exact
2. identifier la ligne concernée
3. expliquer la cause probable
4. proposer une correction minimale
5. ne pas proposer de tout réécrire sauf nécessité

Exemple :

```txt
Erreur : Unresolved reference: Text

Cause probable :
l’import de Text manque.

Ajoute :
import androidx.compose.material3.Text
```

---

# Règles spécifiques Android Studio

## Package

Toujours vérifier le package réel du projet.

Exemples possibles :

```kotlin
package com.example.smilysun
```

ou

```kotlin
package com.vincent.smilysun
```

Ne jamais forcer un package différent sans expliquer les conséquences.

## Manifest

Avant de créer ou corriger une `Activity`, vérifier si `AndroidManifest.xml` contient bien :

```xml
<activity
    android:name=".MainActivity"
    android:exported="true">
```

Si le manifest est différent, adapter l’explication.

## Theme

Ne pas supposer automatiquement que `SmilySunTheme` existe.

Certains templates génèrent :

```kotlin
SmilySunTheme {
    ...
}
```

D’autres non.

Si le thème n’existe pas, ne pas l’utiliser au début.

---

# Concepts déjà clarifiés

## Compose

Jetpack Compose peut être vu comme un framework UI moderne pour Android.

```txt
Kotlin = langage
Android = plateforme
Jetpack Compose = framework UI déclaratif
```

## Composable

Un `@Composable` est un composant UI Compose.

Exemples :

```kotlin
@Composable
fun HomeScreen() {
}
```

Mentalement :

```txt
@Composable function
≈ component UI
```

## Manifest

Le Manifest est un contrat entre l’app et Android.

Il déclare notamment :

- l’application
- les activities
- l’écran de lancement
- les permissions
- le thème
- l’icône
- le nom affiché

Il ne déclare pas les composants Compose comme `HomeScreen` ou `WeatherCard`.

## Column

`Column` est un layout Compose qui place ses enfants verticalement.

```txt
Column
 ├── Text("SmilySun")
 ├── Text("Montréal")
 ├── Text("☀️ 22°C")
 └── Text("Ensoleillé")
```

## Modifier

`Modifier` sert à appliquer du layout, du style ou du comportement à un composant Compose.

Exemple :

```kotlin
Modifier.padding(24.dp)
```

## dp

`dp` signifie density-independent pixels.

C’est une unité Android adaptée aux différentes densités d’écran.

---

# Philosophie du projet

SmilySun doit rester petit au début.

Le succès de la V1 n’est pas d’avoir une app météo complète.

Le succès de la V1 est :

```txt
Vincent comprend ce qu’il a créé.
L’app démarre.
L’interface affiche des données météo fictives.
Le code est assez simple pour être modifié sans peur.
L’architecture reste claire et méthodique.
```

---

# Résumé pour les IA

Quand tu travailles sur SmilySun :

```txt
Ne va pas trop vite.
Explique les concepts.
Ne donne pas de gros blocs sans contexte.
Respecte le projet réel.
Utilise Kotlin + Jetpack Compose.
Garde la V1 sans API.
Priorise la compréhension.
Respecte une architecture propre.
Ajoute de la KDoc utile.
```
