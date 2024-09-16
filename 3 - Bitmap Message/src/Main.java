import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static final String RED_TEXT = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String input = "";

        // Check to see if initial input is valid, otherwise keep asking user for valid input
        while(!isValid) {
            System.out.print("Enter the message to display with the bitmap. ");
            input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println(RED_TEXT + "Please enter a valid string!\n" + RESET);
            } else {
                isValid = true;
            }
        }

        // Read the bitmap file and build a string based on its contents
        try (Scanner fileScanner = new Scanner(Paths.get("bitmap.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] charRowArr = fileScanner.nextLine().split("");
                StringBuilder str = strBuilder(charRowArr, input);
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(RED_TEXT + "File not found" + RESET);
        }
    }

    // Build a new string based on the characters in the array and repeats the input string to fill up the string
    public static StringBuilder strBuilder(String[] arr, String input) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                str.append(" ");
            } else {
                // Ensures that even if the arr is longer than the input string, the characters from the input string are appended cyclically to fill up the string
                str.append(input.charAt(i % input.length()));
            }
        }

        return str;
    }
}