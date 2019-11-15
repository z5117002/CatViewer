package com.example.nyt.database;  // CHANGE ME


import com.example.nyt.model.Cat;
import com.example.nyt.model.CatList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AppDatabase {

    public static HashMap<String, Cat> cats = new HashMap<>();
    public static HashMap<String, CatList> catImages = new HashMap<>();
    public static ArrayList<Cat>  catFavourites = new ArrayList<>();

    public static Cat getCatById(String id) {
        return cats.get(id);
    }

    // shoving api stuff
    public static void saveCatsToDatabase(List<Cat> catsToSave) {
        cats.clear();
        for (int i = 0; i < catsToSave.size(); i++) {
            Cat cat = catsToSave.get(i);
            cats.put(cat.getId(), cat);
        }
    }

    public static void saveCatImagesToDatabase(String id, List<CatList> catImagesToSave) {
        catImages.clear();
        for (int i = 0; i < catImagesToSave.size(); i++) {
            CatList catList = catImagesToSave.get(i);
            catImages.put(id, catList);
        }
    }

    public static ArrayList<Cat> getCatFavourites() {
        return catFavourites;
    }

    public static CatList getImageById(String id) {
        return catImages.get(id);
    }

}
