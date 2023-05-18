package com.partsbuilder.pcbuildproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.partsbuilder.pcbuildproject.fragments.BuildsFragment;
import com.partsbuilder.pcbuildproject.fragments.CreateBuildFragment;
import com.partsbuilder.pcbuildproject.fragments.HomeFragment;
import com.partsbuilder.pcbuildproject.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    BuildsFragment buildsFragment = new BuildsFragment();

    CreateBuildFragment createBuildFragment = new CreateBuildFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigation menu
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
                        return true;
                    case R.id.builds:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, buildsFragment).commit();
                        return true;
                }

                return false;
            }
        });

        // FAB to create new build - go to CreateBuildFragment
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, createBuildFragment).commit();
            }
        });
    }
}