# 01 — Project Structure

Ce fichier explique la structure de base du projet Android **SmilySun**.

L’objectif est de comprendre où sont les fichiers importants et à quoi ils servent.

---

## Vue globale

Dans Android Studio, ton projet ressemble généralement à quelque chose comme ça :

```txt
SmilySun/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── smilysun/
│           │               └── MainActivity.kt
│           └── res/
│               ├── drawable/
│               ├── mipmap-hdpi/
│               ├── mipmap-mdpi/
│               ├── values/
│               │   ├── colors.xml
│               │   ├── strings.xml
│               │   └── themes.xml
│               └── xml/
├── build.gradle.kts
└── settings.gradle.kts
```

Selon ta version d’Android Studio, certains dossiers peuvent être légèrement différents.

---

## `app/`

Le dossier `app/` contient le vrai module Android de l’application.

Pour SmilySun, c’est ici que se trouve :

- le code Kotlin
- les ressources
- le manifest
- la configuration Gradle du module app

On peut voir `app/` comme le cœur de l’application Android.

---

## `app/src/`

Le dossier `src/` veut dire **source**.

C’est là qu’Android range les fichiers qui servent à construire l’application.

Dans une app simple, on utilise surtout :

```txt
app/src/main/
```

---

## `app/src/main/`

Le dossier `main/` contient la version principale de l’application.

Il contient généralement :

```txt
AndroidManifest.xml
java/
res/
```

---

## `AndroidManifest.xml`

Chemin :

```txt
app/src/main/AndroidManifest.xml
```

C’est un fichier très important.

Il sert à déclarer à Android les informations principales de l’app :

- le nom de l’app
- l’icône
- le thème
- les écrans Android importants
- le point d’entrée de l’app
- les permissions éventuelles

Exemple :

```xml
<activity
    android:name=".MainActivity"
    android:exported="true" />
```

Cette ligne dit à Android que l’app possède une Activity appelée `MainActivity`.

Le manifest est expliqué en détail dans :

```txt
docs/learning/02-android-manifest.md
```

---

## `java/`

Chemin actuel dans SmilySun :

```txt
app/src/main/java/com/example/smilysun/
```

Même si le dossier s’appelle `java`, il peut contenir du code Kotlin.

C’est un nom historique dans les projets Android.

Dans SmilySun, on mettra ici les fichiers Kotlin comme :

```txt
MainActivity.kt
WeatherDay.kt
FakeWeatherRepository.kt
HomeScreen.kt
WeatherCard.kt
```

---

## `com/example/smilysun/`

Ce chemin correspond au package Kotlin :

```kotlin
package com.example.smilysun
```

Le chemin :

```txt
com/example/smilysun/
```

et le package :

```kotlin
com.example.smilysun
```

représentent la même organisation, mais écrite différemment.

### Version dossier

```txt
com/example/smilysun
```

### Version Kotlin

```kotlin
package com.example.smilysun
```

---

## `MainActivity.kt`

Chemin :

```txt
app/src/main/java/com/example/smilysun/MainActivity.kt
```

`MainActivity.kt` est le fichier qui contiendra l’écran principal Android.

Au début, il peut être très simple :

```kotlin
package com.example.smilysun

import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
}
```

Cette classe devient une vraie Activity Android grâce à :

```kotlin
: ComponentActivity()
```

---

## `res/`

Chemin :

```txt
app/src/main/res/
```

`res` veut dire **resources**.

Ce dossier contient les ressources non-Kotlin de l’application.

Exemples :

- textes
- couleurs
- thèmes
- icônes
- images
- fichiers XML de configuration

---

## `res/values/`

Ce dossier contient des ressources globales.

Exemples fréquents :

```txt
strings.xml
colors.xml
themes.xml
```

---

## `strings.xml`

Chemin possible :

```txt
app/src/main/res/values/strings.xml
```

Ce fichier contient les textes importants de l’app.

Exemple :

```xml
<string name="app_name">SmilySun</string>
```

Dans le manifest, on peut ensuite utiliser :

```xml
android:label="@string/app_name"
```

Ça veut dire :

```txt
Utilise le texte app_name défini dans strings.xml.
```

---

## `themes.xml`

Chemin possible :

```txt
app/src/main/res/values/themes.xml
```

Ce fichier définit le thème Android de l’application.

Dans le manifest, on peut voir :

```xml
android:theme="@style/Theme.SmilySun"
```

Ça veut dire :

```txt
L’application utilise le style Theme.SmilySun.
```

---

## `build.gradle.kts` du projet

Chemin :

```txt
SmilySun/build.gradle.kts
```

Ce fichier configure le projet global.

Pour l’instant, on n’a pas besoin d’y toucher beaucoup.

---

## `build.gradle.kts` du module app

Chemin :

```txt
SmilySun/app/build.gradle.kts
```

Ce fichier configure le module Android `app`.

C’est ici qu’on trouve souvent :

- la version Android utilisée
- le package / namespace
- la version minimum d’Android
- les dépendances
- la configuration Kotlin
- la configuration Compose

Exemples de concepts qu’on verra plus tard :

```kotlin
namespace = "com.example.smilysun"
minSdk = 26
```

---

## `settings.gradle.kts`

Chemin :

```txt
SmilySun/settings.gradle.kts
```

Ce fichier déclare les modules du projet.

Dans une app simple, il inclut généralement :

```kotlin
include(":app")
```

Ça veut dire :

```txt
Ce projet contient un module appelé app.
```

---

## À retenir

```txt
app/
= module principal de l’application Android

src/main/
= code principal de l’app

AndroidManifest.xml
= déclaration système de l’app

java/com/example/smilysun/
= code Kotlin de SmilySun

res/
= ressources de l’app

build.gradle.kts
= configuration du build
```

---

## Résumé simple

Pour l’instant, les fichiers les plus importants sont :

```txt
app/src/main/AndroidManifest.xml
app/src/main/java/com/example/smilysun/MainActivity.kt
app/src/main/res/values/strings.xml
app/src/main/res/values/themes.xml
app/build.gradle.kts
```

On va surtout travailler dans :

```txt
MainActivity.kt
AndroidManifest.xml
```

au début du projet.
