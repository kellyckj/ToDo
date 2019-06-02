package com.example.todo;

public class Task {

    private String title;
    private String due_date;
    private String description;

    public Task() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Task(String title, String due_date, String description) {
        this.title = title;
        this.due_date = due_date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setDescription(String description) {
            this.description = description;
        }
}
