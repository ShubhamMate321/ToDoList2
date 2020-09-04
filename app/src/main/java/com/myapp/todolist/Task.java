package com.myapp.todolist;

public class Task {
    String id;
    String title;
    String description;
    String priority;
    String tag;


    public Task(String id, String title, String description, String priority, String tag) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
