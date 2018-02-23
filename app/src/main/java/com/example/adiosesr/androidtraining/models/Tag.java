package com.example.adiosesr.androidtraining.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable {
    @SerializedName("id")
    private Long idTag;
    @SerializedName("name")
    private String nameTag;

    private String imageTag;

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }
}
