package com.ynov;

import java.util.Scanner;

public class CommandLineInterface {
    private Tamagotchis tamagotchi;
    private Scanner scanner;

    public CommandLineInterface() {
        tamagotchi = new Tamagotchis();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            exit = executeAction(choice);
            tamagotchi.passTime(); // Faire passer le temps après chaque action
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("=== TAMAGOTCHI MENU ===");
        System.out.println("1. Play");
        System.out.println("2. Feed");
        System.out.println("3. Clean");
        System.out.println("4. Exit");
        System.out.println("======================");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private boolean executeAction(int choice) {
        switch (choice) {
            case 1:
                tamagotchi.play();
                break;
            case 2:
                tamagotchi.feed();
                break;
            case 3:
                tamagotchi.clean();
                break;
            case 4:
                System.out.println("Exiting...");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
}
