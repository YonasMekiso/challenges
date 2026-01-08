package chapter1_challenge_1.pkg2;

public class Chapter1_Challenge_1_2 {
    public static void main(String[] args) {
        // Initialize the array with winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

        String winningNumber = "";
        double highestAverage = 0;

        // Loop through each winning number
        for (String number : winningNumbers) {
            // Remove dashes
            String continuousString = number.replace("-", "");
            // Convert to character array
            char[] digits = continuousString.toCharArray();
            int sum = 0;

            // Convert characters to integers and calculate sum
            for (char digit : digits) {
                sum += Character.getNumericValue(digit);
            }

            // Calculate average
            double average = (double) sum / digits.length;

            // Print the analysis
            System.out.printf("Analyzing: %s%n", number);
            System.out.printf("Digit Sum: %d, Digit Average: %.1f%n", sum, average);

            // Determine if this is the highest average
            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        // Print the winning number
        System.out.printf("The winning number with the highest average is: %s with an average of %.1f%n", winningNumber, highestAverage);
    }
}