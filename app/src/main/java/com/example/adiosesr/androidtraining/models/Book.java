package com.example.adiosesr.androidtraining.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("pages")
    private Integer pages;
    @SerializedName("author")
    private Author author;
    @SerializedName("tags")
    private List<Tag> tags;
    @SerializedName("description")
    private String description;
    @SerializedName("publication_date")
    private String publiDate;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("idioma")
    private String countryEd;
    @SerializedName("editor")
    private String editor;
    @SerializedName("price")
    private Double price;
    @SerializedName("url")
    private String url;
    @SerializedName("banner")
    private String banner;

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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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
