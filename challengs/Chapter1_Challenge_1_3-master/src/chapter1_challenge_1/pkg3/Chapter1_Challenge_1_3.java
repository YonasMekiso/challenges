package chapter1_challenge_1.pkg3;

import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {

    public static void main(String[] args) {
        // Initialize starting health
        int health = 100;
        Random rand = new Random();
        // Loop through 5 rooms
        try (Scanner scanner = new Scanner(System.in)) {
            // Loop through 5 rooms
            for (int room = 1; room <= 5; room++) {
                System.out.println("Entering room " + room + "...");
                int event = rand.nextInt(3) + 1; // Generate random number between 1 and 3

                switch (event) {
                    case 1: // Trap
                        health -= 20;
                        System.out.println("A trap sprung! Health is now " + health + ".");
                        break;

                    case 2: // Healing potion
                        health += 15;
                        if (health > 100) {
                            health = 100; // Cap health at 100
                            System.out.println("You found a healing potion! Health is now 100 -> capped to 100.");
                        } else {
                            System.out.println("You found a healing potion! Health is now " + health + ".");
                        }
                        break;

                    case 3: // Monster
                        int monsterNumber = rand.nextInt(5) + 1; // Random number for monster
                        int playerGuess;
                        do {
                            System.out.print("A monster appears! Guess a number (1-5) to defeat it: ");
                            playerGuess = scanner.nextInt();
                            if (playerGuess != monsterNumber) {
                                System.out.println("Wrong! Try again.");
                            }
                        } while (playerGuess != monsterNumber);
                        System.out.println("You defeated the monster!");
                        break;
                }

                // Check health after each event
                if (health <= 0) {
                    System.out.println("You have been defeated in room " + room + ".");
                    break; // Exit the loop if health is 0 or below
                }
            }   // Final outcome
            if (health > 0) {
                System.out.println("You cleared the dungeon! Victorious with " + health + " health!");
            }
            // Close the scanner
        }
    }
}
