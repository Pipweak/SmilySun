# SmilySun — Direction UX V1

Ce document décrit la direction produit / écran pour la V1 de **SmilySun**.

Il sert à éviter de coder les modèles et les écrans trop vite sans savoir ce que l’application doit afficher.

---

# Intention générale

SmilySun doit évoluer vers un mix simple entre :

- l’app météo de Google
- MétéoMédia

Mais la V1 doit rester simple, locale et fictive.

Le but n’est pas de copier ces apps. Le but est de s’inspirer de leur structure :

```txt
une météo principale claire
une liste de villes/endroits sauvegardés
une navigation simple entre les écrans
une interface météo visuelle, douce et lisible
```

---

# Écrans envisagés

## 1. Écran météo principal

Nom probable :

```txt
WeatherHomeScreen
```

Rôle : afficher la météo de la ville sélectionnée.

Contenu visé progressivement :

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

Pour la V1, tout cela peut être fictif.

---

## 2. Écran “Mes endroits”

Nom probable :

```txt
SavedLocationsScreen
```

Rôle : afficher et gérer les villes sauvegardées.

Contenu visé :

- bouton retour
- titre : `Mes endroits`
- bouton ajouter
- liste de villes sauvegardées
- ville sélectionnée / active
- température par ville
- condition météo par ville
- icône / emoji météo
- heure locale fictive ou formatée

Exemples de villes possibles :

- Montréal
- Kyoto
- Tokyo
- Istres
- Saint-Sauveur
- Bordeaux
- Québec

---

# Navigation V1

Pour la V1, la navigation peut rester très simple.

Objectif final souhaité :

```txt
WeatherHomeScreen
→ ouvre SavedLocationsScreen
→ sélectionne une ville
→ revient à WeatherHomeScreen avec la ville sélectionnée
```

L’effet de slide ou transition entre écrans est souhaitable plus tard, mais pas obligatoire au début.

Priorité :

```txt
fonctionnel d’abord
transition / animation ensuite
```

---

# Implication sur les modèles de données

Important : les modèles actuels sont temporaires.

Le modèle initial `WeatherDay` est utile pour apprendre, mais il ne représente probablement pas toute la V1 finale.

La direction UX montre qu’on aura probablement besoin de modèles plus proches de :

```txt
WeatherLocation
CurrentWeather
DailyForecast
HourlyForecast
```

Mais il ne faut pas tout créer immédiatement.

Règle :

```txt
Les modèles doivent évoluer selon :
1. les écrans qu’on décide de construire
2. les données fictives nécessaires à ces écrans
3. plus tard, la forme des données de l’API météo choisie
```

Donc pour l’instant :

```txt
WeatherDay = modèle pédagogique temporaire
```

Il pourra être renommé, découpé ou remplacé plus tard.

---

# Approche recommandée

## Maintenant

Continuer doucement avec les données fictives.

Ne pas over-engineer.

Créer seulement ce dont l’écran a besoin.

## Plus tard

Quand les écrans seront plus clairs :

- créer un modèle pour une ville sauvegardée
- créer un modèle pour la météo actuelle
- créer un modèle pour les prévisions
- créer une source de données fictive plus complète
- adapter ensuite aux données d’une vraie API météo

---

# Direction visuelle

Pour le style, viser progressivement :

- fond doux météo / gradient
- cartes arrondies
- gros affichage de température
- sections empilées verticalement
- contraste lisible
- interface simple et agréable

Mais la V1 n’a pas besoin d’être visuellement parfaite dès maintenant.

Ordre de priorité :

```txt
1. structure claire
2. données bien séparées
3. navigation simple
4. design amélioré progressivement
```

---

# Résumé

SmilySun ne doit pas seulement être un écran météo unique.

La V1 doit aller vers :

```txt
une app météo locale/fictive
avec un écran météo principal
et un écran Mes endroits
qui permet de gérer/choisir des villes
```

Les modèles de données doivent rester souples et évoluer avec les écrans et la future API météo.
