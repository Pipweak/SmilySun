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
- [x] Branche `main` réservée aux releases
- [x] Étape 1 terminée
- [x] Étape 2 terminée
- [x] Étape 3 commencée : modèle météo `WeatherDay`
- [x] Direction UX V1 clarifiée
- [x] Début de données fake locales
- [x] Début de l’écran `Mes endroits`
- [x] Début du refactor en packages `ui`, `screen`, `component`, `model`, `data`

Important : on n’avance plus strictement étape par étape. On reste majoritairement dans l’étape 3, mais on a volontairement fait un peu d’étape 4, 8 et 11 pour garder le projet cohérent.

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

# Objectif V1

Créer une V1 simple d’une application météo Android avec :

- [x] une première interface statique
- [x] une météo du jour fictive statique
- [x] plusieurs villes fictives dans une source locale
- [ ] une prévision sur quelques jours
- [ ] une vraie sélection de ville
- [x] une structure de code plus claire en fichiers séparés
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

## Fonctionnalités présentes

- [x] Afficher le nom de l’application : SmilySun
- [x] Afficher une ville active : Montréal
- [x] Afficher une température : 22°C
- [x] Afficher une condition météo : Ensoleillé
- [x] Afficher un emoji météo : ☀️
- [x] Afficher un petit message météo
- [x] Préparer plusieurs villes fictives
- [x] Afficher temporairement une section `Mes endroits`

## Fonctionnalités restantes

- [ ] Afficher une prévision sur 3 jours
- [ ] Transformer `Mes endroits` en vrai écran navigable
- [ ] Changer de ville avec une sélection simple
- [ ] Ajouter une navigation simple entre météo principale et `Mes endroits`

---

# Affichage actuel attendu

```txt
SmilySun

Montréal
☀️ 22°C
Ensoleillé

Belle journée pour sortir un peu.

Mes endroits
Montréal — ☀️ 22°C
Tokyo — 🌤️ 27°C
Kyoto — ☁️ 24°C
Québec — 🌥️ 18°C
```

L’affichage est encore volontairement brut. Le but actuel est de poser la structure, pas de finaliser le design.

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

Note actuelle : le fichier `WeatherHomeScreen.kt` existe. La fonction peut encore s’appeler `HomeScreen` selon le dernier WIP local. À nettoyer dans la prochaine passe pour que nom de fichier et nom de composable soient alignés.

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

État actuel : l’écran est préparé, mais pas encore branché à une navigation réelle.

---

# Modèles de données : note importante

Le modèle actuel `WeatherDay` est utile pour apprendre, mais il est temporaire.

Les modèles devront évoluer selon :

```txt
1. les écrans construits
2. les données fictives nécessaires
3. plus tard, les données reçues par l’API météo choisie
```

Modèles probables plus tard :

```txt
WeatherLocation
CurrentWeather
DailyForecast
HourlyForecast
```

Mais on ne crée pas tout maintenant.

---

# Structure actuelle

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

## Responsabilités actuelles

```txt
MainActivity
= point d’entrée Android uniquement

SmilySunApp
= racine Compose, prépare les données fake et affiche l’écran principal

WeatherHomeScreen.kt
= écran météo principal, reçoit les données à afficher

SavedLocationsScreen.kt
= futur écran Mes endroits, préparé mais pas encore navigable

SavedLocationsSection / SavedLocationRow
= composants temporaires pour afficher les villes sauvegardées

WeatherDay
= modèle pédagogique temporaire

FakeWeatherRepository
= source de données fictives locale
```

---

# Plan de développement

## Étape 1 — Créer le projet Android

Statut : terminé.

- [x] Ouvrir Android Studio
- [x] Créer le projet `SmilySun`
- [x] Utiliser Kotlin
- [x] Ajouter Jetpack Compose manuellement via Gradle
- [x] Vérifier le package réel : `com.example.smilysun`
- [x] Vérifier `MainActivity.kt`
- [x] Vérifier `AndroidManifest.xml`
- [x] Déclarer `MainActivity` dans le Manifest
- [x] Ajouter `MAIN`
- [x] Ajouter `LAUNCHER`
- [x] Ajouter `onCreate`
- [x] Ajouter `setContent`
- [x] Afficher `Text("SmilySun")`
- [x] Créer un émulateur local stable
- [x] Lancer l’app

---

## Étape 2 — Créer un premier écran statique

Statut : terminé.

- [x] Créer `SmilySunApp`
- [x] Créer un premier écran météo
- [x] Ajouter `Column`
- [x] Afficher `SmilySun`
- [x] Afficher `Montréal`
- [x] Afficher `☀️ 22°C`
- [x] Afficher `Ensoleillé`
- [x] Afficher un message météo statique
- [x] Ajouter `padding`
- [x] Ajouter `fillMaxSize`
- [x] Centrer avec `Arrangement.Center`
- [x] Centrer horizontalement avec `Alignment.CenterHorizontally`
- [x] Ajouter `fontSize`
- [x] Ajouter `Spacer`
- [x] Ajouter de la KDoc simple

---

# Étape 3 — Créer le modèle météo

Statut : en cours.

Objectif : sortir les valeurs météo de l’UI pour commencer à séparer données et affichage.

- [x] Créer le package `model`
- [x] Créer `WeatherDay.kt`
- [x] Créer une `data class WeatherDay`
- [x] Ajouter `city`
- [x] Ajouter `temperature`
- [x] Ajouter `condition`
- [x] Ajouter `emoji`
- [x] Ajouter `message`
- [x] Comprendre `val` vs `var`
- [x] Passer `weather: WeatherDay` à l’écran météo principal
- [x] Commencer à retirer les valeurs hardcodées de l’UI
- [ ] Décider si `WeatherDay` reste le modèle de transition pour la suite immédiate
- [ ] Renommer/aligner `HomeScreen` en `WeatherHomeScreen` si ce n’est pas déjà fait dans le code

---

# Étape 4 — Créer des données météo fictives

Statut : commencée.

- [x] Créer le package `data`
- [x] Créer `FakeWeatherRepository.kt`
- [x] Créer un objet `FakeWeatherRepository`
- [x] Ajouter une météo fictive pour Montréal
- [x] Ajouter plusieurs villes fictives
- [x] Ajouter `savedLocations`
- [x] Ajouter `todayWeather = savedLocations.first()`
- [ ] Décider si le repository doit maintenant exposer des modèles plus adaptés que `WeatherDay`

---

# Étape 5 — Brancher l’interface sur les données

Statut : commencée.

- [x] Ne plus écrire toutes les valeurs météo directement dans l’UI
- [x] Utiliser un objet `WeatherDay`
- [x] Afficher `weather.temperature`
- [x] Afficher `weather.city`
- [x] Afficher `weather.condition`
- [x] Afficher `weather.emoji`
- [x] Afficher `weather.message`
- [ ] Préparer le futur changement vers une API météo

---

# Étape 6 — Créer une carte météo

Statut : à venir.

- [ ] Créer un composant `WeatherCard`
- [ ] Passer les données nécessaires en paramètre
- [ ] Afficher l’emoji météo
- [ ] Afficher la température
- [ ] Afficher la condition
- [ ] Afficher le message
- [ ] Comprendre les composants réutilisables

---

# Étape 7 — Ajouter une prévision sur 3 jours

Statut : à venir.

- [ ] Créer une liste `forecast`
- [ ] Ajouter 3 journées météo
- [ ] Afficher la liste
- [ ] Créer `ForecastList`
- [ ] Créer `ForecastItem`
- [ ] Comprendre `listOf`
- [ ] Comprendre l’affichage d’une liste

---

# Étape 8 — Ajouter une sélection de ville / Mes endroits

Statut : commencée.

- [x] Créer plusieurs villes fictives
- [x] Créer `SavedLocationRow`
- [x] Créer `SavedLocationsSection`
- [x] Préparer `SavedLocationsScreen`
- [x] Afficher temporairement les villes sauvegardées
- [ ] Brancher une vraie navigation vers `SavedLocationsScreen`
- [ ] Ajouter un bouton ou une action pour ouvrir `Mes endroits`
- [ ] Ajouter une sélection de ville
- [ ] Comprendre `remember`
- [ ] Comprendre `mutableStateOf`
- [ ] Changer la météo selon la ville choisie

---

# Étape 9 — Améliorer le style visuel

Statut : à venir.

- [ ] Choisir une direction artistique simple
- [ ] Ajouter un fond doux / gradient
- [ ] Ajouter une carte météo arrondie
- [ ] Améliorer la typographie
- [ ] Ajouter des couleurs selon la météo
- [ ] Garder une interface lisible

---

# Étape 10 — Ajouter une mini animation

Statut : à venir.

- [ ] Faire bouger légèrement le soleil
- [ ] Faire apparaître la carte météo doucement
- [ ] Tester une animation simple
- [ ] Garder le code compréhensible
- [ ] Ne pas complexifier trop tôt

---

# Étape 11 — Nettoyer le code

Statut : commencée.

- [x] `MainActivity.kt` contient seulement le point d’entrée Android
- [x] Créer `ui/SmilySunApp.kt`
- [x] Créer `ui/screen/WeatherHomeScreen.kt`
- [x] Créer `ui/screen/SavedLocationsScreen.kt`
- [x] Créer `ui/component/SavedLocationRow.kt`
- [x] Créer `ui/component/SavedLocationsSection.kt`
- [x] Créer `model/WeatherDay.kt`
- [x] Créer `data/FakeWeatherRepository.kt`
- [ ] Créer `WeatherCard.kt`
- [ ] Créer `ForecastList.kt`
- [ ] Créer `ForecastItem.kt`
- [ ] Vérifier les noms de fonctions et fichiers après refactor

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

- [x] données météo locales simples
- [x] écran météo principal préparé
- [x] écran `Mes endroits` préparé
- [x] plusieurs villes fictives
- [ ] prévision sur 3 jours
- [ ] sélection de ville fonctionnelle
- [ ] UI propre
- [x] composants séparés progressivement

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

# Prochaine étape

Faire un point technique avant de continuer :

- [ ] vérifier que le projet compile après refactor
- [ ] vérifier si `WeatherHomeScreen.kt` exporte bien `WeatherHomeScreen` ou encore `HomeScreen`
- [ ] si besoin, aligner le nom du composable avec le fichier
- [ ] ensuite seulement, ajouter l’état de navigation simple dans `SmilySunApp`
