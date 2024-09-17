import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the encrypted Caesar Cipher message to hack.");
        String message = scanner.nextLine();
        System.out.println();
        char[] MESSAGE_ARR = message.toUpperCase().toCharArray();

        // Print out each iteration of decryption starting from key 1 up to key 25
        for (int i = 1; i < 26; i++) {
            System.out.println("Key #" + i + ": " + decrypt(MESSAGE_ARR, i));
        }
    }

    private static String decrypt(char[] MESSAGE_ARR, int key) {
        char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder str = new StringBuilder();

        for (char c : MESSAGE_ARR) {
            // Add space to string if there is space in original message
            if (c == ' ') {
                str.append(" ");
                // Add original character if character is not a letter (e.g. special character)
            } else if (!Character.isLetter(c)) {
                str.append(c);
            }

            for (int i = 0; i < LETTERS.length; i++) {
                if (c == LETTERS[i]) {
                    int index;

                    // Shift the index to the left of the LETTERS arr by subtracting index of letter from key mod 26
                    index = (i - key) % LETTERS.length;

                    if (index < 0) {
                        index += LETTERS.length;
                    }

                    str.append(LETTERS[index]);
                }
            }
        }

        return str.toString();
    }
}