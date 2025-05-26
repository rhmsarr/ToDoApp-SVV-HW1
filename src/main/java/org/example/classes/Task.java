package org.example.classes;

public class Task {
    private final String title;
    private final String description;
    private Boolean completed;
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }
    public String isDone(){
        return completed ? "[✔]" : "[ ]";
    }
    public String getTask(){
        return isDone() + " " + title + "\n"  + description;
    }
    public void setCompleted(){
        completed = true;
    }

}
