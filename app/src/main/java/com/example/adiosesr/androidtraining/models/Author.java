package com.example.adiosesr.androidtraining.models;

import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("first_Name")
    private String firstName;
    @SerializedName("last_Name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
