package com.example.nyt.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.nyt.R;
import com.example.nyt.fragments.CatRecyclerFragment;
import com.example.nyt.fragments.FavouritesRecyclerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// Notice the Activity implements the interface OnFragmentInteractionListener, meaning this Activity
// MUST have the method defined by the interface (see bottom), and if it does then this Activity
// can be considered an OnFragmentInteractionListener; it listens for Fragment interaction.
// This is only relevant to ProfileFragment in this app (because ArticleRecyclerFragment has nothing
// to listen to).
public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new CatRecyclerFragment();
        swapFragment(fragment);

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_search) {
                    Fragment fragment = new CatRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_favourites) {
                    Fragment fragment = new FavouritesRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }

        });

    }

    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }
}