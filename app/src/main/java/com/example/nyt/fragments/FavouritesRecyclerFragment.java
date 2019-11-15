package com.example.nyt.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyt.FavouritesAdapter;
import com.example.nyt.R;



public class FavouritesRecyclerFragment extends Fragment {

    private RecyclerView recyclerView;

    public FavouritesRecyclerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav_rv, container, false);
        recyclerView = view.findViewById(R.id.fav_rv_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        FavouritesAdapter favAdapter = new FavouritesAdapter();
        recyclerView.setAdapter(favAdapter);

        return view;
    }
}
