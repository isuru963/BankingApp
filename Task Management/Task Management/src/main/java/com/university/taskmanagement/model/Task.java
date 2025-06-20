package com.university.taskmanagement.model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String status; // pending, in-progress, completed
    private int priority; // 1-3

    // Constructors
    public Task() {}

    public Task(int id, String title, String description, String status, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}