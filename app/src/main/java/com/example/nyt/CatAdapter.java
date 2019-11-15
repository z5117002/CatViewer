package com.example.nyt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyt.activities.CatDetailActivity;
import com.example.nyt.model.Cat;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatListViewHolder> {

    private List<Cat> catsToAdapt;

    public void setData(List<Cat> catsToAdapt) {
        this.catsToAdapt = catsToAdapt;
    }

    @NonNull
    @Override
    public CatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);
        return new CatListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatListViewHolder holder, int position) {
        final Cat catAtPosition = catsToAdapt.get(position);

        holder.catName.setText(catAtPosition.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, CatDetailActivity.class);
                intent.putExtra("CatId", catAtPosition.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public class CatListViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView catName;

        public CatListViewHolder(@NonNull View v) {
            super(v);
            view = v;
            catName = v.findViewById(R.id.cat_list_name);
        }
    }
}