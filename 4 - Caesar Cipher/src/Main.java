import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = -1;
        String command = "";
        boolean keyIsValid = false;
        boolean commandIsValid = false;
        boolean run = true;

        while (run) {
            // Get the command (either encrypt or decrypt)
            do {
                System.out.print("Do you want to (e)ncrypt or (d)ecrypt? ");

                try {
                    command = scanner.nextLine();

                    if (command.equalsIgnoreCase("e") || command.equalsIgnoreCase("d")) {
                        commandIsValid = true;
                    } else {
                        System.out.println("Input is neither 'e' or 'd'. Try again.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Your input is not valid. Please enter e or d.\n");
                }
            } while (!commandIsValid);

            // Get the key
            do {
                System.out.print("\nPlease enter the key (0 - 25) to use: ");

                try {
                    key = Integer.parseInt(scanner.nextLine());

                    if (key > 0 && key < 25) {
                        keyIsValid = true;
                    } else {
                        System.out.println("Key is not within range. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a number between 0 and 25.");
                }
            } while (!keyIsValid);

            // Check what command the user entered to give the correct output
            if (command.equalsIgnoreCase("e")) {
                System.out.println("\nEnter the message to encrypt.");
            } else {
                System.out.println("\nEnter the message to decrypt.");
            }
            String message = scanner.nextLine();

            // Run the encryption/decryption
            System.out.println("\nYour Message" + "\n" + ed(command, key,  message));

            // Replay algorithm
            System.out.print("\nDo you want to encrypt/decrypt another message? (y/n) ");
            String replay = scanner.nextLine();

            if (replay.equalsIgnoreCase("n")) {
                run = false;
                System.out.println("Ending program...");
                System.exit(0);
            }
        }

        scanner.close();
    }

    private static String ed(String command, int key, String message) {
        char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] MESSAGE_ARR = message.toUpperCase().toCharArray();
        StringBuilder str = new StringBuilder();

        for (char c : MESSAGE_ARR) {
            // Add space to string if there is space in original message
            if (c == ' ') {
                str.append(" ");
            } else if (!Character.isLetter(c)) {
                str.append(c);
            }

            // Encrypt/decrypt
            for (int k = 0; k < LETTERS.length; k++) {
                // Checks for a match
                if (c == LETTERS[k]) {
                    int index;
                    // Command is to encrypt
                    if (command.equals("e")) {
                        // Shift the index to the right of the LETTERS arr by adding index of letter to key mod 26
                        index = (k + key) % LETTERS.length;
                        str.append(LETTERS[index]);
                    } else if (command.equals("d")) {
                        // Shift the index to the left of the LETTERS arr by subtracting index of letter from key mod 26
                        index = (k - key) % LETTERS.length;

                        // Handle any negative values
                        if (index < 0) {
                            index += LETTERS.length;
                        }

                        str.append(LETTERS[index]);
                    }
                }
            }
        }

        return str.toString();
    }
}