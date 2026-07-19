import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        // setting up scanner and random generator
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        // printing welcome info
        System.out.println("Welcome to the number guessing game!");
        System.out.println("The Secret number is between 0-1000");

        // variables for the game
        int guess = 0;
        int random;
        int repeated = 0; // count for double wrong or same inputs
        random = ran.nextInt(1001); // random number from 0 to 1000
        int[] AllGuess = new int[10]; // storing old guesses here
        int count = 0; // keeping track of total turns

        // main loop for 10 attempts
        while (count < 10) {
            // printing user's old guesses
            System.out.print("All previous guesses are: ");
            for (int i = 0; i < count; i++) {
                System.out.print(AllGuess[i] + " ");
            }
            System.out.println();
            System.out.print("Please enter your Guess: ");

            // checking if the input is actually a number
            if (!sc.hasNextInt()) {
                sc.next(); // clear wrong input
                repeated++;
                System.out.println("Invalid input! you can't enter anything except numbers");

                // if user puts wrong inputs twice, cut one turn
                if (repeated >= 2) {
                    count++;
                    System.out.println("you have lost guess due to repeated invalid input");
                }
                continue; // ask input again
            }

            guess = sc.nextInt(); // get the user number
            repeated = 0; // clear consecutive mistakes counter

            // number check for 0 to 1000 limit
            if (guess < 0 || guess > 1000) {
                System.out.println("Please enter number between 0 and 999");
                continue;
            }

            // checking if user already tried this number before
            boolean guessed = false;
            for (int i = 0; i < count; i++) {
                if (AllGuess[i] == guess) {
                    guessed = true;
                    break;
                }
            }

            // penalty for repeating the same guess twice
            if (guessed) {
                repeated++;
                System.out.println("You have already guessed this number");

                if (repeated >= 2) {
                    count++;
                    System.out.println("one guess lost due to you have entered repeated guess");
                }
                continue;
            }

            // add new guess to history array and update count
            AllGuess[count] = guess;
            count++;

            // checking if guess matches the random number
            if (guess == random) {
                System.out.println("Congratulations! You have guessed the correct secret number");
                System.out.println("You have won the Game!");
                break; // win and stop game
            } else if (guess > random) {
                System.out.println("Your Guess is bigger");
            } else if (guess < random) {
                System.out.println("Your guess is smaller");
            }

            // showing turns left
            System.out.println("You have "+ (10-count) +" guesses left");
        }

        // if loop finished and still not matched means game over
        if (count == 10 && guess != random) {
            System.out.println("Allowed guesses are finished");
            System.out.println("OOPS! You have lost the game");
            System.out.println("Please try again!");
            System.out.println("The secret number was: " + random);
        }

        // high score logic starts here
        if (guess == random) {
            int currentAttempts = count;
            int highestScore = 11; // default score if file not found
            File file = new File("highscore.txt");

            // read old score from text file if exists
            if (file.exists()) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    if (fileScanner.hasNextInt()) {
                        highestScore = fileScanner.nextInt();
                    }
                    fileScanner.close();
                } catch (IOException e) {
                    System.out.println("Error reading high score file.");
                }
            }

            // if current score is better, write it to file
            if (currentAttempts < highestScore) {
                System.out.println("New Best Record! You guessed it in just " + currentAttempts + " attempts.");
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(String.valueOf(currentAttempts));
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error saving new high score.");
                }
            } else {
                System.out.println("Current Best Record is: " + highestScore + " attempts.");
            }
        }
    }
}
