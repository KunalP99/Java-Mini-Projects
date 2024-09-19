package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TodoManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private TodoManager manager;
    private TodoList list;

    @BeforeEach
    void setUp() {
        list = new TodoList();
        manager = new TodoManager(list);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should add to list successfully from user input")
    void addTodoToListSuccessfully() {
        String todo1 = "task 1";
        manager.add(todo1);
        assertEquals(1, list.listSize());
    }

    @Test
    @DisplayName("Should remove todo from list successfully from user input")
    void removeTodoFromListSuccessfully() {
        String todo1 = "task 1";
        manager.add(todo1);
        assertEquals(1, list.listSize());

        manager.remove(todo1);
        assertEquals(0, list.listSize());
    }

    @Test
    void setTodoToComplete() {
        // First input is the task name ("task 1"), second input is "y"
        String simulatedInput = "task 1\ny";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in); // Set the simulated input

        String todo1 = "task 1";
        manager.add(todo1);

        // Call the set method, which should read from the simulated input
        manager.set(new Scanner(System.in));

        // Assert that the task has been marked as completed
        assertTrue(list.getList().getFirst().isCompleted());

        // Restore System.in after the test to avoid side effects
        System.setIn(System.in);
    }

    @Test
    @DisplayName("Set the todo complete to false if it's true")
    void setTodoToNotCompleteIfAlreadyComplete() {
        String simulatedInput = "task 1\nn";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in); // Set the simulated input

        String todo1 = "task 1";
        manager.add(todo1);

        list.getList().getFirst().setCompleted(true);
        manager.set(new Scanner(System.in));
        assertFalse(list.getList().getFirst().isCompleted());
    }
}