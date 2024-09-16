import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;

        // Checks to see if the users input is valid, otherwise simulation will not run
        while (!validInput) {
            try {
                System.out.print("How many birthdays shall I generate (Max 100) ");
                input = Integer.parseInt(scanner.nextLine());

                if (input <= 100) {
                    validInput = true;
                } else {
                    System.out.println("You did not enter a number less than or equal to 100.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Please enter a valid integer!");
            }
        }

        // If the input is less than 100, only then run the rest of the code
        System.out.println("Here are " + input + " birthdays:");
        ArrayList<String> dates = createDatesList(input);

        for (String date : dates) {
            System.out.print(date + ", ");
        }

        // Check to see if in the initial simulation of input size, there are multiple of the same date
        boolean datesMatch = false;
        for (int i = 0; i < dates.size(); i++) {
            for(int k = i + 1; k < dates.size(); k++) {
                if (dates.get(i).equals(dates.get(k))) {
                    System.out.println("\nIn this simulation, multiple people have a birthday on " + dates.get(i));
                    datesMatch = true;
                    break;
                }
            }
        }

        if (!datesMatch) {
            System.out.println("\nIn this simulation, no one has the same birthday.");
        }

        System.out.println("Generating " + input + " random birthdays 100,000 times");
        System.out.print("Pres ENTER to begin... (Or type in QUIT to exit simulation) ");

        String command = scanner.nextLine();

        // Run the simulation or exit simulation
        if (command.isEmpty()) {
            simulation(input);
        } else if (command.equals("Quit".toLowerCase())) {
            System.exit(0);
        }
    }

    // Runs the simulation 100,000 times to find a matching date per group based on input size
    public static void simulation(int input) {
        // Running the simulation 100,000 times based on input by the user
        int count = 0;
        ArrayList<String> dates;

        for (int i = 0; i < 100_000; i++) {
            dates = createDatesList(input);

            if (i % 10000 == 0) {
                System.out.println(i + " simulations run...");
            }

            // Finds a matching date in each group of dates, and when it does, break out of the loop as we only want to find at most, 1 pair of matching dates
            boolean match = false;
            for (int k = 0; k < dates.size() && !match; k++) {
                for (int j = k + 1; j < dates.size(); j++) {
                    if (dates.get(k).equals(dates.get(j))) {
                        count++;
                        match = true;
                        break;
                    }
                }
            }
        }

        double percentage = ((double) count / 100_000) * 100;

        System.out.println("Out of 100,000 simulations of " + input + " people, there was a matching birthday in that group " + count + " times.");
        System.out.println("This means that " + input + " people have a " + percentage + "% chance of having a matching birthday in their group.");
    }

    // Create an array list based on the input size, and generate that amount of random dates
    public static ArrayList<String> createDatesList(int input) {
        ArrayList<String> dates = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            dates.add(generateRandomDate());
        }

        return dates;
    }

    // Generates a random date within the range given, coverts the date range to epoch and gets a date based on the epoch values
    public static String generateRandomDate() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        // Convert dates to epoch
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        // Format will return e.g. Jan 04
        return randomDate.format(DateTimeFormatter.ofPattern("MMM dd"));
    }
}