package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private TodoList list;

    @BeforeEach
    void setUp() {
        list = new TodoList();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void getTodoList() {
        ArrayList<Todo> testList = new ArrayList<>();
        assertEquals(testList, list.getList());
    }

    @Test
    @DisplayName("Get the correct size of the list when items are added")
    void getsCorrectSizeOfListWhenItemsAreAdded() {
        Todo todo1 = new Todo("task 1");
        Todo todo2 = new Todo("task 2");

        list.add(todo1);
        list.add(todo2);

        assertEquals(2, list.listSize());
    }

    @Test
    void addTodoToList() {
        Todo todo = new Todo("task 1");
        list.add(todo);
        assertEquals(1, list.listSize());
    }

    @Test
    @DisplayName("Empty todo should not be added to the todo list")
    void emptyTodoShouldNotBeAddedToList() {
        Todo todo = new Todo(" ");
        list.add(todo);
        assertEquals(0, list.listSize());
    }

    @Test
    @DisplayName("Remove a single todo from the list")
    void removeSingleTodoFromList() {
        Todo todo1 = new Todo("task 1");
        list.add(todo1);

        assertEquals(1, list.listSize());

        list.remove(todo1);
        assertEquals(0, list.listSize());
    }

    @Test
    @DisplayName("Remove multiple todos from the list")
    void removeMultipleTodosFromList() {
        Todo todo1 = new Todo("task 1");
        Todo todo2 = new Todo("task 2");
        Todo todo3 = new Todo("task 3");

        list.add(todo1);
        list.add(todo2);
        list.add(todo3);
        assertEquals(3, list.listSize());

        list.remove(todo1);
        list.remove(todo2);
        list.remove(todo3);
        assertEquals(0, list.listSize());
    }

    @Test
    @DisplayName("Print list in correct format when multiple todos are added")
    void printListInCorrectFormatWithMultipleTodo() {
        Todo todo1 = new Todo("task 1");
        Todo todo2 = new Todo("task 2");
        Todo todo3 = new Todo("task 3");

        list.add(todo1);
        list.add(todo2);
        list.add(todo3);

        list.print();

        // Normalize the line endings of the actual output
        String[] expectedLines = {"1. task 1", "2. task 2", "3. task 3"};
        String[] actualLines = outContent.toString().trim().split("\\r?\\n");

        assertArrayEquals(expectedLines, actualLines);
    }
}