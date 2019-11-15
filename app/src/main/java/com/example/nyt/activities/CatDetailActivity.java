package com.example.nyt.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.nyt.R;
import com.example.nyt.database.AppDatabase;
import com.example.nyt.model.Cat;
import com.example.nyt.model.CatList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Cat> catFavourites = AppDatabase.getCatFavourites();
    Cat cat;

    TextView catName;
    TextView catDescription;
    TextView catWeight;
    TextView catTemperament;
    TextView catOrigin;
    TextView catLifeSpan;
    TextView catDogFriendly;
    TextView catWikiUrl;

    ImageView catImage;

    Button favourite;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_detail);

        Intent intent = getIntent();
        String catId = intent.getStringExtra("CatId");

        cat = AppDatabase.getCatById(catId);

        catName = findViewById(R.id.cat_detail_name);
        catDescription = findViewById(R.id.cat_detail_description);
        catWeight = findViewById(R.id.cat_detail_weight);
        catTemperament = findViewById(R.id.cat_detail_temper);
        catOrigin = findViewById(R.id.cat_detail_origin);
        catLifeSpan = findViewById(R.id.cat_detail_life);
        catDogFriendly = findViewById(R.id.cat_detail_dog);
        catWikiUrl = findViewById(R.id.cat_detail_link);

        catImage = findViewById(R.id.cat_detail_image);

        catName.setText(cat.getName());
        catDescription.setText(cat.getDescription());

        // breaks if no weight...
        if (cat.getWeight() != null) {
            catWeight.setText(cat.getWeight().getMetric() + " kg");
        }

        catTemperament.setText(cat.getTemperament());
        catOrigin.setText(cat.getOrigin());
        catLifeSpan.setText(cat.getLifeSpan()+ " years");
        catDogFriendly.setText(Long.toString(cat.getDogFriendly()));
        catWikiUrl.setText(cat.getWikipediaUrl());

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.thecatapi.com/v1/images/search?breed_id="+ cat.getId();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CatList[] catLists = gson.fromJson(response, CatList[].class);
                List<CatList> catList = Arrays.asList(catLists);

                AppDatabase.saveCatImagesToDatabase(cat.getId(), catList);
                Log.e("CatBreedID:", cat.getId());
                System.out.println(AppDatabase.catImages);

                if (!(AppDatabase.catImages.isEmpty())) {
                    String imageUrl = AppDatabase.getImageById(cat.getId()).getImageUrl();
                    Glide.with(getApplicationContext()).load(imageUrl).into(catImage);
                }

                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("u dumb egged");
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

        favourite = findViewById(R.id.add_button);
        favourite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean exists = false;
        for (Cat c: catFavourites) {
            if (c.getId().equals(cat.getId())) {
                exists = true;
            }
        }

        if (exists) {
            Toast.makeText(this, cat.getName() + " is already in your favourites!", Toast.LENGTH_SHORT)
                    .show();
        } else {
            catFavourites.add(cat);
            Toast.makeText(this, "You've added " + cat.getName() + " to your favourites!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
