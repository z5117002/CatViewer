package com.example.nyt.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CatList {

    @SerializedName("url")
    private String imageUrl;

    private ArrayList<Cat> breeds;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
