package org.example.exercices.exo5;

import java.util.UUID;

public class Task {
    private String id;
    private String description;
    private boolean completed;

    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
