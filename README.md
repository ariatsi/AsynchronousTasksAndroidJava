# TP Guidé - Tâches asynchrones Android

Ce projet pédagogique a pour objectif de construire une application
Android capable d'exécuter un travail long en arrière-plan sans bloquer
l'interface utilisateur.

Il s'appuie sur le TP guidé « Tâches asynchrones Android ».

# Objectif du TP

Créer une application Android (Java) qui :

-   Lance un travail long en arrière-plan
-   Affiche un état (Prêt / Travail en cours / Terminé)
-   Met à jour dynamiquement l'interface
-   Survit à la rotation de l'écran
-   Nettoie correctement ses ressources

# Problème de départ

Certaines applications Android deviennent inutilisables lorsqu'un calcul
long est exécuté directement sur le thread principal.

Conséquences typiques :

-   Interface figée
-   Boutons inactifs
-   Écran non réactif
-   Mauvaise expérience utilisateur

Ce TP permet de comprendre pourquoi cela arrive et comment l'éviter
proprement.

# Architecture mise en place

L'application repose sur une séparation claire des responsabilités :

Activity\
Affiche l'interface et observe les données.

ViewModel\
Contient la logique métier et exécute le travail en arrière-plan.

LiveData\
Transporte les informations entre le ViewModel et l'Activity.

ExecutorService\
Permet d'exécuter du code dans un thread secondaire.

# Étapes principales du TP

## 1. Création du projet

Création d'une application simple avec :

-   Un texte affichant l'état de la tâche
-   Une barre de progression
-   Un bouton pour démarrer le travail

## 2. Comprendre le problème du blocage

Simulation volontaire d'un mauvais comportement afin d'observer :

-   Le gel de l'interface
-   L'impossibilité d'interagir avec l'écran
-   L'impact d'un travail exécuté sur le thread principal

## 3. Mise en place d'une architecture robuste

Création d'un ViewModel contenant :

-   Un état textuel observable
-   Un indicateur de chargement
-   Une gestion locale des threads via ExecutorService

Introduction à LiveData pour rendre l'interface réactive
automatiquement.

## 4. Connexion de l'Activity au ViewModel

L'Activity :

-   Observe les données exposées
-   Met à jour automatiquement l'interface
-   Démarre le travail au clic

Le travail long est exécuté en arrière-plan sans jamais bloquer l'UI.

## 5. Test de robustesse : rotation

Pendant l'exécution de la tâche, l'écran est tourné.

Résultat attendu :

-   L'application ne plante pas
-   Le travail continue
-   L'état est conservé
-   L'interface se reconnecte automatiquement aux données

## 6. Ajout d'une progression réelle

Amélioration de l'expérience utilisateur :

-   Passage d'une barre indéterminée à une progression de 0 à 100
-   Mise à jour dynamique de la progression
-   Synchronisation entre état interne et affichage

## 7. Nettoyage propre des ressources

Ajout d'un mécanisme de fermeture des threads lorsque le ViewModel est
détruit afin :

-   D'éviter les fuites de ressources
-   De respecter les bonnes pratiques Android
-   De garantir une application propre et professionnelle

# Compétences développées

-   Compréhension du thread principal Android
-   Exécution de tâches en arrière-plan
-   Architecture ViewModel + LiveData
-   Gestion des changements de configuration
-   Mise à jour réactive de l'interface
-   Nettoyage des ressources

# Résumé des bonnes pratiques

-   Ne jamais bloquer le thread principal
-   Utiliser un thread secondaire pour les travaux longs
-   Séparer logique métier et interface
-   Mettre à jour l'UI via LiveData
-   Gérer correctement la rotation
-   Nettoyer les threads lorsque le ViewModel est détruit

# Améliorations possibles

-   Ajouter un bouton Annuler
-   Simuler un téléchargement réel
-   Gérer plusieurs tâches simultanées
-   Ajouter un historique des exécutions

## Licence

Ce projet est distribué sous la licence **Academic Free License v3.0 ([AFL-3.0](https://opensource.org/licenses/AFL-3.0))**.