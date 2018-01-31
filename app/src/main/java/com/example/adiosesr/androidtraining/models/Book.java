package com.example.adiosesr.androidtraining.models;

/**
 * Created by adiosesr on 30/01/2018.
 */

public class Book {
    private Integer Id;
    private String name;
    private Integer pages;
    private Autor autor;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
