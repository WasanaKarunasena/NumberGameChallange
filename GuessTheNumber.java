import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        playNum();
    }

    public static void playNum() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 15;
        int roundsGuessed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\n**** Round " + (roundsGuessed + 1) + "****");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Enter your guess (between " + minRange + " and " + maxRange + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == secretNumber) {
                    System.out.println("WOW!!! You guessed the correct number in " + attempt + " attempts.");
                    totalAttempts += attempt;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                }
            }

            roundsGuessed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        // Display the user's score
        System.out.println("\n**** Game Over ****");
        System.out.println("Rounds played: " + roundsGuessed);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.printf("Average attempts per round: %.2f%n", (double) totalAttempts / roundsGuessed);

        scanner.close();
    }
}
