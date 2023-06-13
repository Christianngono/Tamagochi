package com.ynov;


public class Tamagotchis {
    private int stage; // Stade de vie du Tamagotchi
    private int happinessLevel; // Niveau de bonheur
    private int hungerLevel; // Niveau de faim

    public Tamagotchis() {
        // Initialisation des valeurs par défaut
        stage = 0; // 0 pour l'oeuf
        happinessLevel = 15;
        hungerLevel = 0;
    }

    // Méthode pour jouer avec le Tamagotchi
    public void play() {
        if (stage != 0) { // Vérifier si l'oeuf a éclos
            // Effectuer les actions nécessaires pour jouer
            happinessLevel += 3; // Augmenter le niveau de bonheur de 3 points
            // Autres actions spécifiques à l'action de jouer
        }
    }

    // Méthode pour nourrir le Tamagotchi
    public void feed() {
        if (stage != 0) { // Vérifier si l'oeuf a éclos
            // Effectuer les actions nécessaires pour nourrir
            hungerLevel = 0; // Réinitialiser le niveau de faim à 0
            // Autres actions spécifiques à l'action de nourrir
        }
    }

    // Méthode pour nettoyer l'environnement du Tamagotchi
    public void clean() {
        if (stage != 0) { // Vérifier si l'oeuf a éclos
            // Effectuer les actions nécessaires pour nettoyer
            // Autres actions spécifiques à l'action de nettoyer
        }
    }

    // Méthode pour faire passer le temps et mettre à jour l'état du Tamagotchi
    public void passTime() {
        if (stage == 0) {
            // Gérer le passage du temps pour l'oeuf
            stage = 1; // L'oeuf éclos, le Tamagotchi devient un bébé
        } else if (stage == 1) {
            // Gérer le passage du temps pour le bébé
            // Vérifier les conditions pour devenir adulte
            if (hungerLevel >= 4 && happinessLevel >= 40) {
                stage = 2; // Le Tamagotchi devient adulte
            }
            // Autres actions spécifiques au stade de bébé
        } else if (stage == 2) {
            // Gérer le passage du temps pour l'adulte
            // Vérifier les conditions pour devenir vieillard
            // Vérifier les conditions pour mourir
            // Autres actions spécifiques au stade d'adulte
        } else if (stage == 3) {
            // Gérer le passage du temps pour le vieillard
            // Vérifier les conditions pour mourir
            // Autres actions spécifiques au stade de vieillard
        }
    }

    public String getHappinessLevel() {
        return null;
    }

    public String getHungerLevel() {
        return null;
    }
}
