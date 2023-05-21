package com.partsbuilder.pcbuildproject.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.partsbuilder.pcbuildproject.R;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflater for layout
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        // CardView for gamer
        CardView gamecard1 = homeView.findViewById(R.id.gamecard1);
        CardView gamecard2 = homeView.findViewById(R.id.gamecard2);
        CardView gamecard3 = homeView.findViewById(R.id.gamecard3);

        // game recommendation card 1
        gamecard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 1",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // game recommendation card 2
        gamecard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 2",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // game recommendation card 1
        gamecard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 3",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // CardView for Architect
        CardView architectcard1 = homeView.findViewById(R.id.architectcard1);
        CardView architectcard2 = homeView.findViewById(R.id.architectcard2);
        CardView architectcard3 = homeView.findViewById(R.id.architectcard3);

        // architect recommendation 1
        architectcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 4",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // architect recommendation 2
        architectcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 5",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // architect recommendation 3
        architectcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 6",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // CardView for Video Editors
        CardView editorcard1 = homeView.findViewById(R.id.editorcard1);
        CardView editorcard2 = homeView.findViewById(R.id.editorcard2);
        CardView editorcard3 = homeView.findViewById(R.id.editorcard3);

        // editor recommendation 1
        editorcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 7",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // editor recommendation 2
        editorcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 8",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        // editor recommendation 3
        editorcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pressed Card 9",Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        return homeView;
    }
}