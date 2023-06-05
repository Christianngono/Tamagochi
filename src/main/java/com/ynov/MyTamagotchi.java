package com.ynov;

import java.util.Scanner;


public class MyTamagotchi implements tamagotchi {
    private int happiness = 15;
    private int hunger = 0;
    private boolean isDirty = false;
    private boolean isSick = false;
    
    @Override
    public void play() {
        if (happiness >= 50) {
            System.out.println("Votre Tamagotchi est déjà très heureux !");
        } else {
            happiness += 3;
            System.out.println("Vous avez joué avec votre Tamagotchi. Son bonheur a augmenté de 3 points.");
        }
            passTime();
    }
    
    @Override
    public void feed() {
        if (hunger <= 0) {
            System.out.println("Votre Tamagotchi n'a pas faim pour le moment.");
        } else {
            hunger--;
            System.out.println("Vous avez nourri votre Tamagotchi. Sa faim a diminué de 1 point.");
        }
            passTime();
    }
    
    @Override
    public void clean() {
        if (isDirty) {
            isDirty = false;
            System.out.println("Vous avez nettoyé l'environnement de votre Tamagotchi.");
        } else {
            System.out.println("L'environnement de votre Tamagotchi est déjà propre.");
        }
            passTime();
    }
    
    @Override
    public void heal() {
        if (!isSick) {
            System.out.println("Votre Tamagotchi n'est pas malade pour le moment.");
        } else {
            isSick = false;
            System.out.println("Vous avez soigné votre Tamagotchi. Il est maintenant en bonne santé.");
        }
            passTime();
    }
    
    private void passTime() {
        hunger++;
        if (hunger > 2) {
            happiness -= hunger * 5;
        }
    
        if (hunger > 4) {
            System.out.println("Votre Tamagotchi est affamé ! Sa faim est à un niveau critique !");
        }
    
        if (happiness <= 0) {
            System.out.println("Votre Tamagotchi est triste et malheureux. Il est mort...");
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        MyTamagotchi tamagotchi = new MyTamagotchi();
        tamagotchi.Interact();
    }

    private void Interact() {
        Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Que voulez-vous faire ?");
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
                System.out.println("Au revoir !");
                scanner.close();
                return;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                break;
            }
        }
    }
}
