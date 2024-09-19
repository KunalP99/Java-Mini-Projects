package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    private Todo todo;

    @BeforeEach
    void setUp() {
        todo = new Todo("task 1");
    }

    @Test
    void getTodoName() {
        assertEquals("task 1", todo.getName());
    }

    @Test
    void completedShouldBeInitialisedAsFalse() {
        assertFalse(todo.isCompleted());
    }

    @Test
    @DisplayName("Should switch complete boolean from false to true when called with true")
    void isTrueWhenIsCompletedIsCalledWithTrue() {
        todo.setCompleted(true);
        assertTrue(todo.isCompleted());
    }

    @Test
    @DisplayName("Should switch complete boolean from true to false when called with false")
    void isFalseWhenIsCompletedIsCalledWithFalse() {
        todo.setCompleted(false);
        assertFalse(todo.isCompleted());
    }

    @Test
    @DisplayName("Print correct string when task is not completed")
    void printCorrectStringWhenTaskNotCompleted() {
        assertEquals("task 1", todo.toString());
    }

    @Test
    @DisplayName("Print correct string when task is completed")
    void printCorrectStringWhenTaskIsCompleted() {
        String todoName = "task 1";

        todo.setCompleted(true);
        assertEquals(todoName + " ✅", todo.toString());
    }
}