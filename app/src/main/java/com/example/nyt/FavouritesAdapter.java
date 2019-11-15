package com.example.nyt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyt.database.AppDatabase;
import com.example.nyt.model.Cat;

import java.util.List;

// We need to give a type in angle brackets <> when we extend RecyclerView.Adapter
// It's saying that we want an adapter that adapts to ArticleViewHolder (our custom ViewHolder)
public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.CatFavViewHolder> {

    private List<Cat> catFavs = AppDatabase.getCatFavourites();

    @NonNull
    @Override
    public CatFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);
        return new FavouritesAdapter.CatFavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatFavViewHolder holder, int position) {
        final Cat catAtPosition = catFavs.get(position);
        holder.catName.setText(catAtPosition.getName());
    }

    @Override
    public int getItemCount() {
        return catFavs.size();
    }

    public class CatFavViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView catName;

        public CatFavViewHolder(@NonNull View v) {
            super(v);
            view = v;
            catName = v.findViewById(R.id.cat_list_name);
        }
    }
}