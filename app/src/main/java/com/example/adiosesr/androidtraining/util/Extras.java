package com.example.adiosesr.androidtraining.util;
public enum Extras {

    EXTRAS_DATANAME("dataname"),
    EXTRAS_BOOKS("books"),
    EXTRAS_SECTION_NUMBER("section_number");


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