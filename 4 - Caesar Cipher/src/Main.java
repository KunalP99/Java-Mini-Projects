import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to (e)ncrypt or (d)ecrypt? ");
        String command = scanner.nextLine();

        System.out.println("\nPlease enter the key (0 - 25) to use.");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("\nEnter the message to encrypt.");
        String message = scanner.nextLine();

        System.out.println(ed(command, key,  message));
    }

    private static String ed(String command, int key, String message) {
        char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] messageArr = message.toUpperCase().toCharArray();
        StringBuilder str = new StringBuilder();

        for (char c : messageArr) {
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