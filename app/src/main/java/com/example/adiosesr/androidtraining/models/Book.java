package com.example.adiosesr.androidtraining.models;


import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private Integer id;
    private String name;
    private Integer pages;
    private Author author;
    private List<Tag> tags;
    private String description;
    private String publiDate;
    private String isbn;
    private String countryEd;
    private String numEdition;
    private Double price;
    private String url;
    private String banner;

    //Para pruebas
    public Book(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public Book() {
    }

    //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubliDate() {
        return publiDate;
    }

    public void setPubliDate(String publiDate) {
        this.publiDate = publiDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCountryEd() {
        return countryEd;
    }

    public void setCountryEd(String countryEd) {
        this.countryEd = countryEd;
    }

    public String getNumEdition() {
        return numEdition;
    }

    public void setNumEdition(String numEdition) {
        this.numEdition = numEdition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
