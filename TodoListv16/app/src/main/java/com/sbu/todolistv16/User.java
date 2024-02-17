package com.sbu.todolistv16;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String Username;
    private String Description;
    private String Expiration;
    private boolean Done = false;

    public User(String username , String description , String expiration){
        this.Username = username;
        this.Description = description;
        this.Description = expiration;
    }

    protected User(Parcel in) {
        Username = in.readString();
        Description = in.readString();
        Expiration = in.readString();
        Done = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Username);
        dest.writeString(Description);
        dest.writeString(Expiration);
        dest.writeByte((byte) (Done ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername(){
        return Username;
    }

    public String getDescription(){
        return Description;
    }

    public String getExpiration(){
        return Expiration;
    }

    public boolean getDon(){
        return Done;
    }

    public void setUsername(String username){
        this.Username = username;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public void setExpiration(String expiration){
        this.Expiration = expiration;
    }

    public void setDone(boolean done){
        this.Done = done;
    }
}
