package chapter1_challenge_1.pkg1;

// Project Name: Chapter1_Challenge_1_1

public class Challenge1 {
    // Function to decode the cryptic message
    public static void decodeMessage(int input) {
        // Input: positive integer
        int num = input;

        // Extract the first digit
        int firstDigit = (int) Math.floor(num / Math.pow(10, Math.floor(Math.log10(num))));

        // Extract the last digit
        int lastDigit = num % 10;

        // Calculate the product of the first and last digit
        int product = firstDigit * lastDigit;

        // Extract the second digit
        int secondDigit = (num / 1000) % 10;

        // Extract the second-last digit
        int secondLastDigit = (int) Math.floor((num / 10) % 10);

        // Calculate the sum of the second digit and the second-last digit
        int sum = secondDigit + secondLastDigit;

        // Create the final code by concatenating product and sum
        String finalCode = String.valueOf(product) + sum;

        // Output the decrypted code
        System.out.println("The decrypted code is: " + finalCode);
    }

    public static void main(String[] args) {
        // Example input
        decodeMessage(13579);
    }
}