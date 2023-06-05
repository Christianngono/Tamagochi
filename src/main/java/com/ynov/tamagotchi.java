package com.ynov;

    
import java.util.Scanner;

public interface tamagotchi {
    Scanner scanner = new Scanner(System.in);

    void play();
    void feed();
    void clean();
    void heal();

    default void interact() {
        boolean isRunning = true;

        System.out.println("Bienvenue dans le jeu Tamagotchi !");
        System.out.println("Votre Tamagotchi est né.");

        while (isRunning) {
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Jouer");
            System.out.println("2. Nourrir");
            System.out.println("3. Nettoyer");
            System.out.println("4. Soigner");
            System.out.println("5. Quitter");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    play();
                    break;
                case 2:
                    feed();
                    break;
                case 3:
                    clean();
                    break;
                case 4:
                    heal();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }

        System.out.println("Merci d'avoir joué !");
    }
}
