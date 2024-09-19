package org.example;

import java.util.Iterator;
import java.util.Scanner;

public class TodoManager {
    TodoList list;

    public TodoManager(TodoList list) {
        this.list = list;
    }

    // Add to list
    public void add(String todo) {
        if (todo.trim().isEmpty()) {
            System.out.println("Please enter a todo.");
        } else {
            list.add(new Todo(todo));
            System.out.println("\n" + todo + " successfully added!");
        }
    }

    // Remove from list
    public void remove(String toRemove) {
        Iterator<Todo> iterator = list.getList().iterator();

        // Safely remove elements from an array list using iterator
        while(iterator.hasNext()) {
            Todo todo = iterator.next();

            if (todo.getName().equals(toRemove)) {
                iterator.remove();
                System.out.println(todo.getName() + " successfully removed!");
            }
        }
    }

    // Print all in the list
    public void print() {
        System.out.println("\nYour todo list");
        list.print();
    }

    // Set todo as completed/uncompleted
    public void set(Scanner scanner) {
        boolean isRun = true;

        do {
            System.out.print("Which todo do you want to modify (Enter name)? ");

            try {
                String toModify = scanner.nextLine();
                boolean todoFound = false;

                for (Todo todo : list.getList()) {
                    if (todo.getName().equals(toModify)) {
                        System.out.print("Is this todo complete (y/n)? ");
                        String complete = scanner.nextLine();

                        // Set todo as completed or not
                        todo.setCompleted(complete.equals("y"));
                        System.out.println(todo.getName() + " successfully modified");
                        isRun = false;
                        todoFound = true;
                        break;
                    }
                }

                if (!todoFound) {
                    System.out.println("Not found. Here is your list. Please try again.");
                    list.print();
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while(isRun);
    }
}
