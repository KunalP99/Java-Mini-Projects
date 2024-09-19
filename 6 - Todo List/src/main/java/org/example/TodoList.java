package org.example;

import java.util.ArrayList;

public class TodoList {
    private final ArrayList<Todo> list;

    public TodoList() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Todo> getList() {
        return list;
    }

    public void add(Todo todo) {
        if (!todo.getName().trim().isEmpty()) {
            list.add(todo);
        }
    }

    public void remove(Todo todo) {
        list.remove(todo);
    }

    public int listSize() {
        return list.size();
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
