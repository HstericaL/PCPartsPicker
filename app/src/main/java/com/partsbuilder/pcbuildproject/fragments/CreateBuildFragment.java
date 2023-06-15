package com.partsbuilder.pcbuildproject.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        // insert intel 8th gen and 9th gen processor for LGA 1151
        dbHelper.insertProcessor("Intel", "i3-8100", "1151", "4 Cores, 4 Threads", 3.6f, 65, 4500.0f);
        dbHelper.insertProcessor("Intel", "i3-8300", "1151", "4 Cores, 4 Threads", 3.7f, 65, 5500.0f);
        dbHelper.insertProcessor("Intel", "i5-8400", "1151", "6 Cores, 6 Threads", 2.8f, 65, 7000.0f);
        dbHelper.insertProcessor("Intel", "i5-8500", "1151", "6 Cores, 6 Threads", 3f, 65, 8000.0f);
        dbHelper.insertProcessor("Intel", "i5-8600", "1151", "6 Cores, 6 Threads", 3.1f, 65, 9000.0f);
        dbHelper.insertProcessor("Intel", "i7-8700", "1151", "6 Cores, 12 Threads", 3.2f, 65, 12000.0f);
        dbHelper.insertProcessor("Intel", "i3-9100", "1151", "4 Cores, 4 Threads", 3.6f, 65, 4750.0f);
        dbHelper.insertProcessor("Intel", "i5-9400", "1151", "6 Cores, 6 Threads", 2.9f, 65, 7250.0f);
        dbHelper.insertProcessor("Intel", "i5-9500", "1151", "6 Cores, 6 Threads", 3f, 65, 8250.0f);
        dbHelper.insertProcessor("Intel", "i5-9600", "1151", "6 Cores, 6 Threads", 3.1f, 65, 9250.0f);
        dbHelper.insertProcessor("Intel", "i7-9700", "1151", "8 Cores, 8 Threads", 3f, 65, 13250.0f);

        // insert intel 9th gen and 10th gen processor for LGA 1200
        dbHelper.insertProcessor("Intel", "i3-10100", "1200", "4 Cores, 8 Threads", 3.6f, 65, 9299.0f);
        dbHelper.insertProcessor("Intel", "i5-10500", "1200", "6 Cores, 12 Threads", 3.1f, 65, 12769.0f);
        dbHelper.insertProcessor("Intel", "i5-10600", "1200", "6 Cores, 12 Threads", 3.3f, 65, 14499.0f);
        dbHelper.insertProcessor("Intel", "i5-10600K", "1200", "6 Cores, 12 Threads", 4.1f, 125, 17329.0f);
        dbHelper.insertProcessor("Intel", "i7-10700", "1200", "8 Cores, 16 Threads", 2.9f, 65, 19889.0f);
        dbHelper.insertProcessor("Intel", "i7-10700K", "1200", "8 Cores, 16 Threads", 3.6f, 125, 22769.0f);
        dbHelper.insertProcessor("Intel", "i9-10900", "1200", "10 Cores, 20 Threads", 2.9f, 65, 24329.0f);
        dbHelper.insertProcessor("Intel", "i9-10900K", "1200", "10 Cores, 20 Threads", 3.7f, 125, 29649.0f);
        dbHelper.insertProcessor("Intel", "i3-11100", "1200", "4 Cores, 8 Threads", 3.1f, 65, 7995.0f);
        dbHelper.insertProcessor("Intel", "i5-11400", "1200", "6 Cores, 12 Threads", 2.6f, 65, 12995.0f);
        dbHelper.insertProcessor("Intel", "i5-11600", "1200", "6 Cores, 12 Threads", 2.6f, 65, 14995.0f);
        dbHelper.insertProcessor("Intel", "i5-11600K", "1200", "6 Cores, 12 Threads", 3.7f, 125, 17995.0f);
        dbHelper.insertProcessor("Intel", "i7-11700", "1200", "8 Cores, 12 Threads", 2.8f, 65, 19995.0f);
        dbHelper.insertProcessor("Intel", "i7-11700K", "1200", "8 Cores, 16 Threads", 3.6f, 125, 22995.0f);
        dbHelper.insertProcessor("Intel", "i9-11900", "1200", "8 Cores, 16 Threads", 2.5f, 65, 24995.0f);
        dbHelper.insertProcessor("Intel", "i9-11900K", "1200", "8 Cores, 16 Threads", 3.5f, 125, 29995.0f);

        // insert AMD 1st and 2nd gen Ryzen for AM4
        dbHelper.insertProcessor("AMD", "Athlon 200G", "AM4 1st", "2 Cores, 4 Threads", 3.2f, 35, 2495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 1200", "AM4 1st", "4 Cores, 4 Threads", 3.1f, 65, 3495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 1300X", "AM4 1st", "4 Cores, 4 Threads", 3.5f, 65, 4995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 1400", "AM4 1st", "4 Cores, 8 Threads", 3.2f, 65, 4995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 1500X", "AM4 1st", "4 Cores, 8 Threads", 3.5f, 65, 6945.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 1600", "AM4 1st", "6 Cores, 12 Threads", 3.2f, 65, 5995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 1600X", "AM4 1st", "6 Cores, 12 Threads", 3.6f, 65, 7995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 1700", "AM4 1st", "8 Cores, 16 Threads", 3.0f, 65, 10995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 1700X", "AM4 1st", "8 Cores, 16 Threads", 3.4f, 65, 12995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 1800X", "AM4 1st", "8 Cores, 16 Threads", 3.6f, 65, 14995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 2500G", "AM4 2nd", "4 Cores, 8 Threads", 3.6f, 65, 3995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 2400G", "AM4 2nd", "4 Cores, 8 Threads", 3.6f, 65, 4495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 2600", "AM4 2nd", "6 Cores, 12 Threads", 3.4f, 65, 5995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 2600X", "AM4 2nd", "6 Cores, 12 Threads", 3.6f, 65, 7495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 2700", "AM4 2nd", "8 Cores, 16 Threads", 3.2f, 65, 9995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 2700X", "AM4 2nd", "8 Cores, 16 Threads", 3.7f, 105, 11995.0f);

        //insert AMD 3rd, 4th, 5th gen Ryzen for AM4
        dbHelper.insertProcessor("AMD", "Ryzen 3 3100", "AM4 3rd", "4 Cores, 8 Threads", 3.6f, 65, 3500.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 3200G", "AM4 3rd", "4 Cores, 4 Threads", 3.6f, 65, 4795.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 3300X", "AM4 3rd", "4 Cores, 8 Threads", 3.8f, 65, 6295.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 3600", "AM4 3rd", "6 Cores, 12 Threads", 3.6f, 65, 9995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 3600X", "AM4 3rd", "6 Cores, 12 Threads", 3.8f, 95, 12495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 3700X", "AM4 3rd", "8 Cores, 16 Threads", 3.6f, 65, 16795.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 3800X", "AM4 3rd", "8 Cores, 16 Threads", 3.9f, 105, 19995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 9 3900X", "AM4 3rd", "12 Cores, 24 Threads", 3.8f, 105, 14995.0f);
        //
        dbHelper.insertProcessor("AMD", "Ryzen 3 4100", "AM4 4th", "4 Cores, 8 Threads", 3.8f, 65, 2495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 3 4300G", "AM4 4th", "4 Cores, 8 Threads", 3.8f, 65, 3995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 4500G", "AM4 4th", "6 Cores, 12 Threads", 3.6f, 65, 4995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 4600G", "AM4 4th", "6 Cores, 12 Threads", 3.7f, 65, 5995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 4700", "AM4 4th", "8 Cores, 16 Threads", 3.6f, 65, 7995.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 4700G", "AM4 4th", "8 Cores, 16 Threads", 3.6f, 65, 9995.0f);
        //
        dbHelper.insertProcessor("AMD", "Ryzen 5 5600", "AM4 5th", "6 Cores, 12 Threads", 3.7f, 65, 8450.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 5 5600X", "AM4 5th", "6 Cores, 12 Threads", 3.7f, 65, 9495.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 5700X", "AM4 5th", "8 Cores, 16 Threads", 3.8f, 105, 11295.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 7 5800X", "AM4 5th", "8 Cores, 16 Threads", 3.8f, 105, 14695.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 9 5900", "AM4 5th", "12 Cores, 24 Threads", 3.7f, 105, 19950.0f);
        dbHelper.insertProcessor("AMD", "Ryzen 9 5900X", "AM4 5th", "12 Cores, 24 Threads", 3.7f, 105, 24950.0f);

        // insert motherboard with LGA 1151 and LGA 1200
        dbHelper.insertMotherboard("ASUS", "Prime H310M-K", "1151", 2500.0f);
        dbHelper.insertMotherboard("ASROCK", "H310-HDV", "1151", 2700.0f);
        dbHelper.insertMotherboard("GIGABYTE", "B360M D2V", "1151", 3000.0f);
        dbHelper.insertMotherboard("ASRock", "B460M-HDV", "1200", 4000.0f);
        dbHelper.insertMotherboard("ASUS", "TUF Gaming B560M-PLUS WIFI", "1200", 4500.0f);
        dbHelper.insertMotherboard("GIGABYTE", "Z590 AORUS PRO AX", "1200", 11000.0f);
        dbHelper.insertMotherboard("MSI", "MPG Z490 GAMING EDGE WIFI", "1200", 9500.0f);
        dbHelper.insertMotherboard("ASROCK", " Z590 Extreme WiFi 6E", "1200", 12000.0f);
        dbHelper.insertMotherboard("ASUS", "ROG Maximus XIII Hero", "1200", 17000.0f);
        dbHelper.insertMotherboard("GIGABYTE", "Z690 AORUS ULTRA", "1200", 15000.0f);

        // insert motherboard with AM4 sockets
        dbHelper.insertMotherboard("ASUS", "Prime A320M-K", "AM4 1st", 2800.0f);
        dbHelper.insertMotherboard("ASROCK", "A320M-HDV", "AM4 1st", 2900.0f);
        dbHelper.insertMotherboard("GIGABYTE", "B450M DS3H", "AM4 2nd", 3200.0f);
        dbHelper.insertMotherboard("ASRock", "B450M-HDV", "AM4 2nd", 3300.0f);
        dbHelper.insertMotherboard("ASUS", "TUF B450M-PLUS GAMING", "AM4 2nd", 3600.0f);
        dbHelper.insertMotherboard("GIGABYTE", "B550M DS3H", "AM4 2nd", 5000.0f);
        dbHelper.insertMotherboard("MSI", "MAG B550 TOMAHAWK", "AM4 2nd", 8000.0f);
        dbHelper.insertMotherboard("ASROCK", "X570 Phantom Gaming 4", "AM4 2nd", 10000.0f);
        dbHelper.insertMotherboard("ASUS", "ROG STRIX X570-E GAMING", "AM4 2nd", 14000.0f);
        dbHelper.insertMotherboard("GIGABYTE", "X570 Taichi", "AM4 2nd", 16000.0f);

        // insert cpu cooler
        dbHelper.insertCooler("Noctua NH-D15S", 2890.0f) ;
        dbHelper.insertCooler("Scythe Fuma 2 Rev. B", 2290.0f) ;
        dbHelper.insertCooler("Cooler Master Hyper 212 Black Edition", 1290.0f) ;
        dbHelper.insertCooler("Cooler Master Hyper 212 EVO", 890.0f) ;

        // insert gpu
        // nvidia
        dbHelper.insertGpu("NVIDIA", "GTX 1650", 8995);
        dbHelper.insertGpu("NVIDIA", "GTX 1650 Super", 9995);
        dbHelper.insertGpu("NVIDIA", "GTX 1660", 12995);
        dbHelper.insertGpu("NVIDIA", "GTX 1660 Super", 14995);
        dbHelper.insertGpu("NVIDIA", "GTX 1660 Ti", 17995);
        dbHelper.insertGpu("NVIDIA", "RTX 2060", 23995);
        dbHelper.insertGpu("NVIDIA", "RTX 2060 Super", 27995);
        dbHelper.insertGpu("NVIDIA", "RTX 2070", 35995);
        dbHelper.insertGpu("NVIDIA", "RTX 2070 Super", 40995);
        dbHelper.insertGpu("NVIDIA", "RTX 2080", 56995);
        dbHelper.insertGpu("NVIDIA", "RTX 2080 Super", 64995);
        dbHelper.insertGpu("NVIDIA", "RTX 2080 Ti", 97995);
        dbHelper.insertGpu("NVIDIA", "RTX 3060", 29995);
        dbHelper.insertGpu("NVIDIA", "RTX 3060 Ti", 34995);
        dbHelper.insertGpu("NVIDIA", "RTX 3070", 44995);
        dbHelper.insertGpu("NVIDIA", "RTX 3070 Ti", 50995);
        dbHelper.insertGpu("NVIDIA", "RTX 3080", 62995);
        dbHelper.insertGpu("NVIDIA", "RTX 3080 Ti", 93995);
        dbHelper.insertGpu("NVIDIA", "RTX 3090", 135995);
        // amd
        dbHelper.insertGpu("AMD", "Radeon RX 550", 5500);
        dbHelper.insertGpu("AMD", "Radeon RX 560", 8000);
        dbHelper.insertGpu("AMD", "Radeon RX 570", 10000);
        dbHelper.insertGpu("AMD", "Radeon RX 580", 12000);
        dbHelper.insertGpu("AMD", "Radeon RX 5500 XT", 15000);
        dbHelper.insertGpu("AMD", "Radeon RX 5600 XT", 20000);
        dbHelper.insertGpu("AMD", "Radeon RX 5700", 25000);
        dbHelper.insertGpu("AMD", "Radeon RX 5700 XT", 30000);
        dbHelper.insertGpu("AMD", "Radeon RX 6700 XT", 35000);
        dbHelper.insertGpu("AMD", "Radeon RX 6800", 45000);
        dbHelper.insertGpu("AMD", "Radeon RX 6800 XT", 55000);
        dbHelper.insertGpu("AMD", "Radeon RX 6900 XT", 70000);
        dbHelper.insertGpu("AMD", "Radeon RX 6600 XT", 25000);
        dbHelper.insertGpu("AMD", "Radeon RX 6700 XT", 35000);
        dbHelper.insertGpu("AMD", "Radeon RX 6800", 45000);

        // insert case/chassis
        dbHelper.insertCase("NZXT", "NZXT H510", 2590.00f);
        dbHelper.insertCase("Corsair", "Corsair 4000D Airflow", 3290.00f);
        dbHelper.insertCase("Fractal Design", "Fractal Design Meshify C", 3490.00f);
        dbHelper.insertCase("Cooler Master", "Cooler Master MasterBox TD500 Mesh", 2990.00f);
        dbHelper.insertCase("Phanteks", "Phanteks Eclipse P500A", 3990.00f);
        dbHelper.insertCase("be quiet!", "be quiet! Pure Base 500DX", 4290.00f);
        dbHelper.insertCase("Lian Li", "Lian Li Lancool II Mesh", 3690.00f);
        dbHelper.insertCase("Thermaltake", "Thermaltake View 71 TG", 4990.00f);

        // insert ram
        dbHelper.insertRam("Crucial", "Ballistix Tactical", 8, 3000, "DDR4", 3495.00f);
        dbHelper.insertRam("Kingston", "HyperX Impact", 16, 2666, "DDR4", 4995.00f);
        dbHelper.insertRam("Team", "T-Force Delta RGB", 16, 3200, "DDR4 RGB", 5495.00f);
        dbHelper.insertRam("Patriot", "Viper Steel", 16, 3000, "DDR4", 5995.00f);
        dbHelper.insertRam("Team", "T-Force Dark", 16, 3200, "DDR4", 5995.00f);
        dbHelper.insertRam("Kingston", "HyperX Predator", 16, 3600, "DDR4", 6495.00f);
        dbHelper.insertRam("G.Skill", "Trident Z RGB", 16, 3200, "DDR4 RGB", 6995.00f);
        dbHelper.insertRam("G.Skill", "Ripjaws 4", 32, 3000, "DDR4", 8995.00f);
        dbHelper.insertRam("Corsair", "Vengeance RGB Pro", 32, 3200, "DDR4 RGB", 9995.00f);
        dbHelper.insertRam("Crucial", "Ballistix Elite", 32, 3600, "DDR4", 10995.00f);
        dbHelper.insertRam("ADATA", "XPG Spectrix D50", 32, 3600, "DDR4 RGB", 11995.00f);
        dbHelper.insertRam("Corsair", "Dominator Platinum", 32, 3200, "DDR4", 12995.00f);

        // insert psu
        dbHelper.insertPsu("Corsair RM750x", "750W", "80+ Gold", "Fully", 5500.00f);
        dbHelper.insertPsu("EVGA SuperNOVA 650 G5", "650W", "80+ Gold", "Fully", 4500.00f);
        dbHelper.insertPsu("Seasonic Focus GX-750", "750W", "80+ Gold", "Fully", 6500.00f);
        dbHelper.insertPsu("Cooler Master MWE Gold 650 V2", "650W", "80+ Gold", "Non-Modular", 3500.00f);
        dbHelper.insertPsu("Thermaltake Toughpower GF1 650W", "650W", "80+ Gold", "Fully", 4200.00f);
        dbHelper.insertPsu("be quiet! Straight Power 11 650W", "650W", "80+ Gold", "Fully", 6500.00f);
        dbHelper.insertPsu("SilverStone Strider Gold 750W", "750W", "80+ Gold", "Fully", 5500.00f);
        dbHelper.insertPsu("Antec Earthwatts Gold Pro 650W", "650W", "80+ Gold", "Non-Modular", 4000.00f);
        dbHelper.insertPsu("XPG Core Reactor 750W", "750W", "80+ Gold", "Fully", 5500.00f);
        dbHelper.insertPsu("FSP Hydro G PRO 750W", "750W", "80+ Gold", "Fully", 4500.00f);
        dbHelper.insertPsu("Gigabyte GP-P750GM", "750W", "80+ Gold", "Fully", 4500.00f);
        dbHelper.insertPsu("Cooler Master MWE Gold 750 V2", "750W", "80+ Gold", "Non-Modular", 4000.00f);
        dbHelper.insertPsu("EVGA BQ 650W", "650W", "80+ Bronze", "Non-Modular", 2800.00f);
        dbHelper.insertPsu("Thermaltake Smart RGB 600W", "600W", "80+ White", "Non-Modular", 2200.00f);
        dbHelper.insertPsu("Seasonic S12III 650W", "650W", "80+ Bronze", "Non-Modular", 3000.00f);


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

        //AutoCompleteTextView for searching coolers
        AutoCompleteTextView searchCoolerTextView = createView.findViewById(R.id.searchCoolerTextView);

        // AutoCompleteTextView for searching gpu
        AutoCompleteTextView searchGraphicsTextView = createView.findViewById(R.id.searchGraphicsTextView);

        // AutoCompleteTextView for searching case
        AutoCompleteTextView searchCaseTextView = createView.findViewById(R.id.searchCaseTextView);

        // AutoCompleteTextView for searching ram
        AutoCompleteTextView searchRamTextView = createView.findViewById(R.id.searchRamTextView);

        // AutoCompleteTextView for searching psu
        AutoCompleteTextView searchPsuTextView = createView.findViewById(R.id.searchPsuTextView);


        // Retrieve processor data from the database
        Cursor processorCursor = dbHelper.getProcessorData();
        List<String> processorList = new ArrayList<>();
        if (processorCursor != null && processorCursor.moveToFirst()) {
            do {
                String processorBrand = processorCursor.getString(processorCursor.getColumnIndex("processor_brand"));
                String processorModel = processorCursor.getString(processorCursor.getColumnIndex("processor_model"));
                String processorCoresThreads = processorCursor.getString(processorCursor.getColumnIndex("cores_threads"));
                String processorPrice = processorCursor.getString(processorCursor.getColumnIndex("msrp_php"));
                String part = processorBrand + " " + processorModel +" "+ processorCoresThreads + " ₱" + processorPrice;
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
                String motherboardPrice = motherboardCursor.getString(motherboardCursor.getColumnIndex("price"));
                String part = motherboardBrand + " " + motherboardModel + " ₱" + motherboardPrice;
                motherboardList.add(part);
            } while (motherboardCursor.moveToNext());
            motherboardCursor.close();
        }

        // Retrieve cooler data from the database
        Cursor coolerCursor = dbHelper.getCoolerData();
        List<String> coolerList = new ArrayList<>();
        if (coolerCursor != null && coolerCursor.moveToFirst()) {
            do {
                String coolerModel = coolerCursor.getString(coolerCursor.getColumnIndex("model"));
                String coolerPrice = coolerCursor.getString(coolerCursor.getColumnIndex("price"));
                String part = coolerModel + " ₱" + coolerPrice;
                coolerList.add(part);
            } while (coolerCursor.moveToNext());
            coolerCursor.close();
        }

        // Retrieve gpu data from the database
        Cursor gpuCursor = dbHelper.getGpuData();
        List<String> gpuList = new ArrayList<>();
        if (gpuCursor != null && gpuCursor.moveToFirst()) {
            do {
                String gpuBrand = gpuCursor.getString(gpuCursor.getColumnIndex("brand"));
                String gpuModel = gpuCursor.getString(gpuCursor.getColumnIndex("model"));
                String gpuPrice = gpuCursor.getString(gpuCursor.getColumnIndex("price"));
                String part = gpuBrand + " " + gpuModel + " ₱" + gpuPrice;
                gpuList.add(part);
            } while (gpuCursor.moveToNext());
            gpuCursor.close();
        }

        //Retrieve case data from the database
        Cursor caseCursor = dbHelper.getCaseData();
        List<String> caseList = new ArrayList<>();
        if (caseCursor != null && caseCursor.moveToFirst()) {
            do {
                String caseBrand = caseCursor.getString(caseCursor.getColumnIndex("brand"));
                String caseModel = caseCursor.getString(caseCursor.getColumnIndex("model"));
                String casePrice = caseCursor.getString(caseCursor.getColumnIndex("price"));
                String part = caseBrand + " " + caseModel + " ₱" + casePrice;
                caseList.add(part);
            } while (caseCursor.moveToNext());
            caseCursor.close();
        }

        // Retrieve ram data from database
        Cursor ramCursor = dbHelper.getRamData();
        List<String> ramList = new ArrayList<>();
        if (ramCursor != null && ramCursor.moveToFirst()) {
            do {
                String ramBrand = ramCursor.getString(ramCursor.getColumnIndex("brand"));
                String ramModel = ramCursor.getString(ramCursor.getColumnIndex("model"));
                String ramCapacity = ramCursor.getString(ramCursor.getColumnIndex("capacity"));
                String ramSpeed = ramCursor.getString(ramCursor.getColumnIndex("speed"));
                String ramType = ramCursor.getString(ramCursor.getColumnIndex("type"));
                String ramPrice = ramCursor.getString(ramCursor.getColumnIndex("price"));
                String part = ramBrand + " " + ramModel + " " + ramCapacity + " " + ramSpeed + " " + ramType + " ₱" + ramPrice;
                ramList.add(part);
            } while (ramCursor.moveToNext());
            ramCursor.close();
        }

        // Retrieve psu data from database
        Cursor psuCursor = dbHelper.getPsuData();
        List<String> psuList = new ArrayList<>();
        if (psuCursor != null && psuCursor.moveToFirst()) {
            do {
                String psuModel = psuCursor.getString(psuCursor.getColumnIndex("model"));
                String psuWattage = psuCursor.getString(psuCursor.getColumnIndex("wattage"));
                String psuRating = psuCursor.getString(psuCursor.getColumnIndex("rating"));
                String psuModular = psuCursor.getString(psuCursor.getColumnIndex("modular"));
                String psuPrice = psuCursor.getString(psuCursor.getColumnIndex("price"));
                String part = psuModel + " " + psuWattage + " " + psuRating + " " + psuModular + " ₱" + psuPrice;
                psuList.add(part);
            } while (psuCursor.moveToNext());
            psuCursor.close();
        }

        // Set up ArrayAdapter for searchProcessorTextView
        ArrayAdapter<String> processorAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, processorList);
        searchProcessorTextView.setAdapter(processorAdapter);

        // Set up ArrayAdapter for searchMotherboardTextView
        ArrayAdapter<String> motherboardAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, motherboardList);
        searchMotherboardTextView.setAdapter(motherboardAdapter);

        // Set up ArrayAdapter for searchCoolerTextView
        ArrayAdapter<String> coolerAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, coolerList);
        searchCoolerTextView.setAdapter(coolerAdapter);

        // Set up ArrayAdapter for searchCoolerTextView
        ArrayAdapter<String> gpuAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, gpuList);
        searchGraphicsTextView.setAdapter(gpuAdapter);

        //Set up ArrayAdapter for searchCoolerTextView
        ArrayAdapter<String> caseAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, caseList);
        searchCaseTextView.setAdapter(caseAdapter);

        //Set up ArrayAdapter for searchRamTextView
        ArrayAdapter<String> ramAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, ramList);
        searchRamTextView.setAdapter(ramAdapter);

        //Set up ArrayAdapter for searchPsuTextView
        ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, psuList);
        searchPsuTextView.setAdapter(psuAdapter);

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
