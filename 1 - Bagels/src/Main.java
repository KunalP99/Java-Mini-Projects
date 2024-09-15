import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("I am thinking of a 3-digit number. Try to guess what it is.\nHere are some clues:");
        System.out.println("When I say:     That means:");
        System.out.println("Pico            One digit is correct but in the wrong position.");
        System.out.println("Fermi           One digit is correct and in the right position.");
        System.out.println("Bagels          No digit is correct.\n");

        Scanner scanner = new Scanner(System.in);
        game(scanner);
    }

    // Game functionality
    public static void game(Scanner scanner) {
        String numberToGuess = generateRandomNumber();
        int guesses = 0;

        System.out.println("I have thought up a number.");
        System.out.println("You have 10 guesses to get it.");

        int i = 1;
        while (i <= 10) {
            System.out.print("\nGuess #" + i + ": ");
            String input = scanner.nextLine();
            String[] inputArr = input.split("");
            String[] numberToGuessArr = numberToGuess.split("");

            if (input.equals(numberToGuess)) {
                System.out.println("You got it!");
                replay(scanner);
            }

            compareArrays(inputArr, numberToGuessArr);

            guesses++;
            i++;
        }

        if (guesses >= 10) {
            System.out.println("\nYou lose! You've used up all your guesses!\n");
            System.out.println("This is the correct number: " + numberToGuess);
            replay(scanner);
        }
    }

    // Generate a random number between 0 and 999
    public static String generateRandomNumber() {
        Random random = new Random();
        int number =  random.nextInt(999 - 1 + 1) + 1;

        // Prefixing numbers with 0
        if (number < 10) {
            return "00" + number;
        } else if (number < 100) {
            return "0" + number;
        }

        return String.valueOf(number);
    }

    // Compare input array with computer array and print out fermi or pico
    public static void compareArrays(String[] inputArr, String[] computerArr) {
        boolean bagel = true;

        for (int i = 0; i < inputArr.length; i++) {
            for (int k = 0; k < inputArr.length; k++) {
                if (inputArr[i].equals(computerArr[k])) {
                    // If digit is correct and in correct position
                    bagel = false;

                    if (i == k) {
                        System.out.print("Fermi ");
                        // If digit is correct and in wrong position
                    } else {
                        System.out.print("Pico ");
                    }
                }
            }
        }

        // If no numbers are correct or in the correct position
        if (bagel) {
            System.out.println("Bagel ");
        }
    }

    // Replays the game if the user requests it else it quits the application
    public static void replay(Scanner scanner) {
        System.out.print("\nDo you want to play again? (yes or no) ");
        String input = scanner.nextLine();

        if (input.equals("yes")) {
            System.out.println("");
            game(scanner);
        } else if (input.equals("no")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }
}