package com.example.adiosesr.androidtraining.util;


public enum Extras {


    EXTRAS_NAME ("name"),
    EXTRAS_DATANAME("dataname"),
    EXTRAS_BOOKS("books"),
    EXTRAS_LISTBOOKS("listBook");

    private String extras;

    Extras(String envExtras)
    {
        this.extras = envExtras;
    }
    public String getExtras()
    {
        return extras;
    }
}
