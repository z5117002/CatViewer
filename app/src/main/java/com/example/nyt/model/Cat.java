package com.example.nyt.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {

    @SerializedName("id")
    private String id;
    @SerializedName("weight")
    private Weight weight;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("temperament")
    private String temperament;
    @SerializedName("origin")
    private String origin;
    @SerializedName("dog_friendly")
    private long dogFriendly;
    @SerializedName("life_span")
    private String lifeSpan;
    @SerializedName("wikipedia_url")
    private String wikipediaUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public long getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(long dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    public class Weight {
        private String imperial;
        private String metric;

        public String getImperial() {
            return imperial;
        }

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }
    }
}