import java.util.Random;
import java.util.Scanner;

public class SmartGuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game");

        char playAgain;
        do {
            totalRounds++;
            int secretNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsUsed++;

                if (userGuess == secretNumber) {
                    System.out.println("Correct! You guessed it in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play another round? (y/n): ");
            playAgain = sc.next().toLowerCase().charAt(0);

        } while (playAgain == 'y');

        // Final Score
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Score: " + (roundsWon * 10) + " points");

        sc.close();
    }
}
