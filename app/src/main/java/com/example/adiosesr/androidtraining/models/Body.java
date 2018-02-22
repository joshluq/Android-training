package com.example.adiosesr.androidtraining.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {

    @SerializedName("books")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
