package org.example;

public class Todo {
    private final String name;
    private boolean completed;

    public Todo(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean complete) {
        this.completed = complete;
    }

    public String toString() {
        if (this.completed) {
            return this.name + " ✅";
        }

        return this.name;
    }
}
