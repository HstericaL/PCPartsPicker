package com.partsbuilder.pcbuildproject.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.partsbuilder.pcbuildproject.DBHelper;
import com.partsbuilder.pcbuildproject.R;

import java.util.ArrayList;
import java.util.List;

public class CreateBuildFragment extends Fragment {

    // Database DBHelper
    private DBHelper dbHelper;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CreateBuildFragment() {
        // Required empty public constructor
    }

    public static CreateBuildFragment newInstance(String param1, String param2) {
        CreateBuildFragment fragment = new CreateBuildFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Initialize the DBHelper
        dbHelper = new DBHelper(requireContext());

        // Reset database
        dbHelper.resetDatabase();

        // Insert sample processor and motherboard data for testing
        dbHelper.insertProcessor("Intel", "i7-9700K", "1151", "8 Cores, 8 Threads", 3.6f, 95, 350.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 3600", "AM4", "6 Cores, 12 Threads", 3.6f, 65, 200.0f);

        dbHelper.insertMotherboard("ASUS", "ROG Strix Z390-E", "1151", 250.0f);
        dbHelper.insertMotherboard("GIGABYTE", "B450 AORUS Elite", "AM4", 120.0f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View createView = inflater.inflate(R.layout.fragment_create_build, container, false);

        // AutoCompleteTextView for searching processors
        AutoCompleteTextView searchProcessorTextView = createView.findViewById(R.id.searchProcessorTextView);

        //AutoCompleteTextView for searching motherboards
        AutoCompleteTextView searchMotherboardTextView = createView.findViewById(R.id.searchMotherboardTextView);

        // Retrieve processor data from the database
        Cursor processorCursor = dbHelper.getProcessorData();
        List<String> processorList = new ArrayList<>();
        if (processorCursor != null && processorCursor.moveToFirst()) {
            do {
                String processorBrand = processorCursor.getString(processorCursor.getColumnIndex("processor_brand"));
                String processorModel = processorCursor.getString(processorCursor.getColumnIndex("processor_model"));
                String part = processorBrand + " " + processorModel;
                processorList.add(part);
            } while (processorCursor.moveToNext());
            processorCursor.close();
        }

        //Retrieve motherboard data from the database
        Cursor motherboardCursor = dbHelper.getMotherboardData();
        List<String> motherboardList = new ArrayList<>();
        if (motherboardCursor != null && motherboardCursor.moveToFirst()) {
            do {
                String motherboardBrand = motherboardCursor.getString(motherboardCursor.getColumnIndex("motherboard_brand"));
                String motherboardModel = motherboardCursor.getString(motherboardCursor.getColumnIndex("motherboard_model"));
                String part = motherboardBrand + " " + motherboardModel;
                motherboardList.add(part);
            } while (motherboardCursor.moveToNext());
            motherboardCursor.close();
        }

        // Set up ArrayAdapter for searchProcessorTextView
        ArrayAdapter<String> processorAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, processorList);
        searchProcessorTextView.setAdapter(processorAdapter);

        // Set up ArrayAdapter for searchMotherboardTextView
        ArrayAdapter<String> motherboardAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, motherboardList);
        searchMotherboardTextView.setAdapter(motherboardAdapter);

        // Set up all here


        // Button for creating a new build
        Button createButton = createView.findViewById(R.id.createBuildButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // insert method here on click of create button
            }
        });

        return createView;
    }
}
