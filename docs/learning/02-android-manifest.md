# 02 — Android Manifest

Ce fichier explique le rôle du `AndroidManifest.xml` dans le projet Android **SmilySun**.

Le manifest est un fichier central dans une application Android.

Il sert à dire au système Android :

```txt
Voici ce que mon app contient.
Voici comment elle démarre.
Voici les permissions dont elle a besoin.
Voici son nom, son icône et son thème.
```

---

## Chemin du fichier

Dans SmilySun, le manifest se trouve ici :

```txt
app/src/main/AndroidManifest.xml
```

---

## Image mentale

Tu peux voir le `AndroidManifest.xml` comme un **contrat entre ton application et Android**.

Il ne décrit pas toute ton interface.

Il décrit surtout les informations que le système Android doit connaître.

---

## Analogie avec Angular

Le manifest ressemble un peu à un module Angular, mais seulement au niveau système.

En Angular, un module peut déclarer :

```txt
components
routes
providers
imports
```

En Android, le manifest déclare plutôt :

```txt
activities
permissions
app label
app icon
theme
point d’entrée
services
receivers
```

Différence importante :

Tu ne déclares pas tous tes composants UI Compose dans le manifest.

Par exemple, ces composants ne vont pas dans le manifest :

```kotlin
SmilySunApp()
WeatherCard()
ForecastList()
CitySelector()
```

Ils restent dans le code Kotlin.

---

## Exemple de manifest simple

Exemple adapté à SmilySun :

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.SmilySun">

        <activity
            android:name=".MainActivity"
            android:exported="true">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>

    </application>

</manifest>
```

---

# Les grandes parties du manifest

## `<manifest>`

La balise principale est :

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
```

Elle englobe tout le fichier.

Le `xmlns:android` déclare le namespace Android.

Ça permet d’utiliser des attributs comme :

```xml
android:name
android:label
android:theme
android:icon
```

Sans cette déclaration, Android ne comprendrait pas les attributs `android:`.

---

## `xmlns:tools`

Parfois, Android Studio génère aussi :

```xml
xmlns:tools="http://schemas.android.com/tools"
```

Ce namespace sert seulement si le fichier utilise des attributs qui commencent par `tools:`.

Exemple :

```xml
tools:targetApi="31"
```

Si aucun attribut `tools:` n’est utilisé, Android Studio peut afficher :

```txt
Namespace declaration is never used
```

Dans ce cas, on peut enlever `xmlns:tools`.

Règle simple :

```txt
Si tu utilises tools:quelqueChose → garde xmlns:tools.
Si tu n’utilises aucun tools:quelqueChose → enlève xmlns:tools.
```

---

## `<application>`

La balise `<application>` décrit l’application entière.

Exemple :

```xml
<application
    android:allowBackup="true"
    android:dataExtractionRules="@xml/data_extraction_rules"
    android:fullBackupContent="@xml/backup_rules"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/Theme.SmilySun">
```

Tout ce qui est déclaré dedans appartient à l’application.

Par exemple :

```xml
<activity ...>
```

est déclaré à l’intérieur de `<application>` parce qu’une Activity appartient à l’app.

---

# Attributs importants de `<application>`

## `android:allowBackup`

```xml
android:allowBackup="true"
```

Indique si Android peut sauvegarder certaines données de l’app.

Pour un petit projet d’apprentissage, on peut garder la valeur générée par Android Studio.

---

## `android:dataExtractionRules`

```xml
android:dataExtractionRules="@xml/data_extraction_rules"
```

Indique à Android quelles règles utiliser pour l’extraction ou la sauvegarde de données.

Le fichier correspondant est généralement dans :

```txt
app/src/main/res/xml/data_extraction_rules.xml
```

Pour la V1 de SmilySun, on ne touche pas à ça.

---

## `android:fullBackupContent`

```xml
android:fullBackupContent="@xml/backup_rules"
```

Indique les règles de backup complet de l’application.

Le fichier correspondant est généralement dans :

```txt
app/src/main/res/xml/backup_rules.xml
```

Pour la V1, on garde la valeur générée.

---

## `android:icon`

```xml
android:icon="@mipmap/ic_launcher"
```

Définit l’icône principale de l’app.

`@mipmap/ic_launcher` veut dire :

```txt
Utilise la ressource ic_launcher située dans les dossiers mipmap.
```

Plus tard, on pourra créer une vraie icône SmilySun.

---

## `android:roundIcon`

```xml
android:roundIcon="@mipmap/ic_launcher_round"
```

Définit l’icône ronde de l’app, utilisée par certains launchers Android.

---

## `android:label`

```xml
android:label="@string/app_name"
```

Définit le nom affiché de l’application.

Ici, `@string/app_name` pointe vers une ressource texte dans :

```txt
app/src/main/res/values/strings.xml
```

Exemple :

```xml
<string name="app_name">SmilySun</string>
```

Donc :

```xml
android:label="@string/app_name"
```

veut dire :

```txt
Le nom affiché de l’app est SmilySun.
```

---

## `android:supportsRtl`

```xml
android:supportsRtl="true"
```

Indique que l’app peut supporter les langues écrites de droite à gauche.

Exemples :

- arabe
- hébreu

Pour SmilySun, on peut garder `true`.

---

## `android:theme`

```xml
android:theme="@style/Theme.SmilySun"
```

Définit le thème global de l’app.

Le thème se trouve généralement dans :

```txt
app/src/main/res/values/themes.xml
```

Le thème contrôle des choses comme :

- couleurs système
- apparence générale
- mode clair / sombre
- barre de statut
- style Android de base

---

# `<activity>`

Une Activity est un écran Android reconnu par le système.

Dans SmilySun :

```xml
<activity
    android:name=".MainActivity"
    android:exported="true">
```

Cette balise dit :

```txt
Mon application contient une Activity appelée MainActivity.
```

---

## `android:name=".MainActivity"`

```xml
android:name=".MainActivity"
```

Le point au début veut dire :

```txt
Utilise le package de l’application, puis ajoute MainActivity.
```

Si le package est :

```kotlin
com.example.smilysun
```

Alors :

```xml
android:name=".MainActivity"
```

veut dire :

```txt
com.example.smilysun.MainActivity
```

---

## `android:exported`

```xml
android:exported="true"
```

Indique si cette Activity peut être lancée depuis l’extérieur de l’application.

Pour l’Activity principale avec un `intent-filter`, Android exige souvent que cette valeur soit déclarée explicitement.

Dans le cas de l’écran de lancement :

```xml
android:exported="true"
```

est normal.

---

# `<intent-filter>`

L’`intent-filter` explique comment cette Activity peut être lancée.

Dans SmilySun :

```xml
<intent-filter>
    <action android:name="android.intent.action.MAIN" />
    <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```

Cette partie est très importante.

Elle dit à Android :

```txt
Cette Activity est le point d’entrée principal.
Elle doit apparaître dans le launcher Android.
```

---

## `MAIN`

```xml
<action android:name="android.intent.action.MAIN" />
```

`MAIN` veut dire :

```txt
Cette Activity est le point de départ principal de l’application.
```

Sans `MAIN`, Android ne sait pas forcément que cette Activity doit démarrer l’app.

---

## `LAUNCHER`

```xml
<category android:name="android.intent.category.LAUNCHER" />
```

`LAUNCHER` veut dire :

```txt
Cette Activity peut être lancée depuis l’icône de l’app.
```

Sans `LAUNCHER`, l’app peut exister mais ne pas apparaître comme une app lançable normalement.

---

# Résumé du lancement de l’app

Quand tu cliques sur l’icône SmilySun :

```txt
1. Android lit AndroidManifest.xml.
2. Il cherche une Activity avec MAIN + LAUNCHER.
3. Il trouve MainActivity.
4. Il crée MainActivity.
5. MainActivity exécute onCreate.
6. Plus tard, setContent affichera l’interface Compose.
```

---

# Ce qu’on déclare dans le manifest

On déclare dans le manifest :

```txt
les Activities Android
les permissions
le thème global
l’icône
le nom de l’app
certains services
certains receivers
certaines configurations système
```

---

# Ce qu’on ne déclare pas dans le manifest

On ne déclare pas dans le manifest :

```txt
les Composables Compose
les Text
les Column
les Row
les WeatherCard
les ForecastItem
les variables Kotlin
les data classes
```

Ces éléments restent dans le code Kotlin.

---

# Exemple SmilySun actuel

Pour le moment, SmilySun a besoin au minimum de :

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

C’est la partie qui permet à Android de savoir :

```txt
Quand l’utilisateur lance l’app, démarre MainActivity.
```

---

# À retenir

```txt
AndroidManifest.xml
= fichier de déclaration système

<manifest>
= racine du fichier

<application>
= configuration globale de l’app

<activity>
= écran Android connu par le système

<intent-filter>
= règle qui dit comment l’Activity peut être lancée

MAIN
= point d’entrée principal

LAUNCHER
= lançable depuis l’icône de l’app
```

---

# Résumé simple

Le manifest ne sert pas à construire l’interface.

Il sert à dire à Android :

```txt
Voici mon app.
Voici son nom.
Voici son icône.
Voici son thème.
Voici son écran principal.
Voici comment la lancer.
```

Pour l’interface SmilySun elle-même, on utilisera Kotlin et Jetpack Compose dans `MainActivity.kt`.
