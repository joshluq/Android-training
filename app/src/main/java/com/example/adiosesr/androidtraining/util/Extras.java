package com.example.adiosesr.androidtraining.util;
public enum Extras {
    EXTRAS_NAME ("name"),
    EXTRAS_DATANAME("dataname"),
    EXTRAS_BOOKS("books"),
    EXTRAS_LISTBOOKS("listBook");

    private String extra;

    Extras(String envExtras)
    {
        this.extra = envExtras;
    }
    public String getExtra()
    {
        return extra;
    }
}