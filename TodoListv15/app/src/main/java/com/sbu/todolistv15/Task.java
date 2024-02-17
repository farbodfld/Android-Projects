package com.sbu.todolistv15;

public class Task {
    private String Title;
    private String Description;
    private int Expiration_Date;
    private boolean isDone;

    public Task(String title , String description , int expiration_Date){
        // data haro az az activity begire va inja zakhire kone!
        this.Title = title;
        this.Description = description;
        this.Expiration_Date = expiration_Date;
    }
}
