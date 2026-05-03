# SmilySun — Learning Docs

Cette section sert à documenter ce qu’on apprend pendant la création de l’app Android **SmilySun**.

Le but n’est pas d’avoir une documentation parfaite dès le début.  
Le but est de construire une documentation claire au fur et à mesure, avec des explications simples et liées au vrai projet.

---

## Objectif

Comprendre progressivement :

- la structure d’un projet Android
- le rôle du `AndroidManifest.xml`
- le rôle de `MainActivity`
- les bases de Kotlin
- les bases de Jetpack Compose
- comment afficher une interface
- comment gérer des données locales
- comment préparer une future V2 avec API météo

---

## Structure de cette documentation

```txt
docs/
└── learning/
    ├── index.md
    ├── 01-project-structure.md
    └── 02-android-manifest.md
```

---

## Chapitres disponibles

### 01 — Project Structure

Fichier :

```txt
docs/learning/01-project-structure.md
```

Ce chapitre explique les dossiers principaux d’un projet Android :

- `app/`
- `src/`
- `main/`
- `java/`
- `res/`
- `AndroidManifest.xml`
- `build.gradle.kts`

---

### 02 — Android Manifest

Fichier :

```txt
docs/learning/02-android-manifest.md
```

Ce chapitre explique le rôle de :

- `<manifest>`
- `<application>`
- `<activity>`
- `<intent-filter>`
- `MAIN`
- `LAUNCHER`
- `android:theme`
- `android:label`
- `android:icon`

---

## Chapitres à venir

### 03 — MainActivity

À venir.

Ce chapitre expliquera :

- `MainActivity`
- `ComponentActivity`
- `onCreate`
- `super.onCreate`
- `setContent`

---

### 04 — Kotlin Basics

À venir.

Ce chapitre expliquera :

- `package`
- `import`
- `class`
- `fun`
- `val`
- `var`
- `data class`

---

### 05 — Jetpack Compose Basics

À venir.

Ce chapitre expliquera :

- `@Composable`
- `Text`
- `Column`
- `Row`
- `Modifier`
- `padding`
- `fontSize`

---

## Philosophie

Pour SmilySun, on veut apprendre étape par étape.

Règle importante :

```txt
Un concept appris = une explication claire = un petit exemple dans le projet.
```

On évite de copier-coller de gros blocs de code sans comprendre.

---

## Résumé

Cette documentation est le carnet d’apprentissage de SmilySun.

Elle doit rester :

- simple
- lisible
- progressive
- liée au vrai code du projet
