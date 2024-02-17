package com.fld.todolistv18;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String description;
    private String expire;
    private boolean Done;

    public Task(String title, String description, String expire) {
        this.title = title;
        this.description = description;
        this.expire = expire;
        this.Done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getExpire() {
        return expire;
    }

    public boolean getDone() {
        return Done;
    }

    public void setIsDone(boolean hasDone) {
        this.Done = hasDone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
