package com.example.andrapp;

import android.support.annotation.NonNull;

public class Films {

    private String name;
    private String desc;
    private int rating;
    private int image;

    public Films(String name, int rating, int image) {
        this.name = name;
        this.rating = rating;
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
