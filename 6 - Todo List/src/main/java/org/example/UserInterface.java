package org.example;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    TodoManager manager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.manager = new TodoManager(new TodoList());
    }

    public void start() {
        boolean run = true;

        System.out.println("================================\n");
        System.out.println("""
                Commands:
                add: add a todo to list
                remove: remove todo from list
                print: print your todo list
                set: set if task is complete
                end: quit application
                """);
        System.out.println("================================");

        do {
            try {
                System.out.print("\nEnter your command: ");
                String command = scanner.nextLine().trim().toLowerCase();

                if (command.equals("add")) {
                    System.out.print("Add new todo: ");
                    String todo = scanner.nextLine();
                    manager.add(todo);
                }

                if (command.equals("remove")) {
                    System.out.print("Remove a todo: ");
                    String toRemove = scanner.nextLine();
                    manager.remove(toRemove);
                }

                if (command.equals("print")) {
                    manager.print();
                }

                if (command.equals("set")) {
                    manager.set(scanner);
                }

                if (command.equals("end")) {
                    run = false;
                    quit();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while(run);

        scanner.close();
    }

    public void quit() {
        System.out.println("Ending application...");
        System.exit(0);
    }
}
