package chapter1_challenge_1.pkg4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Chapter1_Challenge_1_4 {
    
    // Custom exception for invalid config version
    static class InvalidConfigVersionException extends Exception {
        public InvalidConfigVersionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("config.txt"));
            String line = reader.readLine();

            // Attempt to parse the first line as an integer
            int configVersion = Integer.parseInt(line); // May throw NumberFormatException

            // Check if the config version is valid
            if (configVersion < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            // Read the second line for the file path
            String filePath = reader.readLine();
            File file = new File(filePath);
            
            // Check if the file exists
            if (!file.exists()) {
                throw new IOException("The file at the specified path does not exist.");
            }

            System.out.println("Config version: " + configVersion);
            System.out.println("File path is valid: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Configuration file not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: The first line is not a valid number.");
        } catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error: Could not close the reader.");
            }
            System.out.println("Config read attempt finished.");
        }
    }
}