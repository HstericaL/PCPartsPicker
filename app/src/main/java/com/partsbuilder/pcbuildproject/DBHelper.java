package com.partsbuilder.pcbuildproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_pcparts.db";
    private static final int DATABASE_VERSION = 6;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create processor table
        db.execSQL("CREATE TABLE IF NOT EXISTS processor(" +
                "processor_brand TEXT," +
                "processor_model TEXT," +
                "socket_generation TEXT," +
                "cores_threads TEXT," +
                "baseclock_ghz REAL," +
                "tdp_w INTEGER," +
                "msrp_php REAL)");

        // Create motherboard table
        db.execSQL("CREATE TABLE IF NOT EXISTS motherboard(" +
                "motherboard_brand TEXT," +
                "motherboard_model TEXT," +
                "socket_generation TEXT," +
                "price REAL)");

        // Create cooler table
        db.execSQL("CREATE TABLE IF NOT EXISTS cooler(" +
                "model TEXT," +
                "price REAL)");

        // Create gpu table
        db.execSQL("CREATE TABLE IF NOT EXISTS gpu(" +
                "brand TEXT," +
                "model TEXT," +
                "price REAL)");

        // Create case table
        db.execSQL("CREATE TABLE IF NOT EXISTS chassis(" +
                "brand TEXT," +
                "model TEXT," +
                "price REAL)");

        // Create ram table
        db.execSQL("CREATE TABLE IF NOT EXISTS ram(" +
                "brand TEXT," +
                "model TEXT," +
                "capacity INTEGER," +
                "speed INTEGER," +
                "type TEXT," +
                "price REAL)");

        // Create psu table
        db.execSQL("CREATE TABLE IF NOT EXISTS psu(" +
                "model TEXT," +
                "wattage TEXT," +
                "rating TEXT," +
                "modular TEXT," +
                "price REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS processor");
        db.execSQL("DROP TABLE IF EXISTS motherboard");
        db.execSQL("DROP TABLE IF EXISTS cooler");
        db.execSQL("DROP TABLE IF EXISTS gpu");
        db.execSQL("DROP TABLE IF EXISTS chassis");
        db.execSQL("DROP TABLE IF EXISTS ram");
        db.execSQL("DROP TABLE IF EXISTS psu");
        onCreate(db);
    }

    public void resetDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("processor", null, null);
        db.delete("motherboard", null, null);
        db.delete("cooler", null, null);
        db.delete("gpu", null, null);
        db.delete("chassis", null, null);
        db.delete("ram", null, null);
        db.delete("psu", null, null);
        // Add more delete statements for other tables

        db.close();
    }

    public boolean insertProcessor(String brand, String model, String socketgeneration,
                                   String coresThreads, float baseClock, int tdp,
                                   float msrp) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("processor_brand", brand);
        values.put("processor_model", model);
        values.put("socket_generation", socketgeneration);
        values.put("cores_threads", coresThreads);
        values.put("baseclock_ghz", baseClock);
        values.put("tdp_w", tdp);
        values.put("msrp_php", msrp);
        long result = db.insert("processor", null, values);
        return result != -1;
    }

    public boolean insertMotherboard(String brand, String model,
                                     String generation, float price) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("motherboard_brand", brand);
        values.put("motherboard_model", model);
        values.put("socket_generation", generation);
        values.put("price", price);
        long result = db.insert("motherboard", null, values);
        return result != -1;
    }

    public boolean insertCooler(String model, float price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("model", model);
        values.put("price", price);
        long result = db.insert("cooler", null, values);
        return result != -1;
    }

    public boolean insertGpu(String brand, String model, float price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("brand", brand);
        values.put("model", model);
        values.put("price", price);
        long result = db.insert("gpu", null, values);
        return result != -1;
    }

    public boolean insertCase(String brand, String model, float price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("brand", brand);
        values.put("model", model);
        values.put("price", price);
        long result = db.insert("chassis", null, values);
        return result != -1;
    }

    public boolean insertRam(String brand, String model, int capacity,
                             int speed, String type, float price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("brand", brand);
        values.put("model", model);
        values.put("capacity", capacity);
        values.put("speed", speed);
        values.put("type", type);
        values.put("price", price);
        long result = db.insert("ram", null, values);
        return result != -1;
    }

    public boolean insertPsu(String model, String wattage, String rating,
                             String modular, float price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("model", model);
        values.put("wattage", wattage);
        values.put("rating", rating);
        values.put("modular", modular);
        values.put("price", price);
        long result = db.insert("psu", null, values);
        return result != -1;
    }

    public Cursor getProcessorData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"processor_brand", "processor_model", "cores_threads", "msrp_php"};
        return db.query("processor", columns, null, null, null, null, null);
    }

    public Cursor getMotherboardData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"motherboard_brand", "motherboard_model", "price"};
        return db.query("motherboard", columns, null, null, null, null, null);
    }

    public Cursor getCoolerData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"model", "price"};
        return db.query("cooler", columns, null, null, null, null, null);
    }

    public Cursor getGpuData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"brand", "model", "price"};
        return db.query("gpu", columns, null, null, null, null, null);
    }

    public Cursor getCaseData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"brand", "model", "price"};
        return db.query("chassis", columns, null, null, null, null, null);
    }

    public Cursor getRamData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"brand", "model", "capacity", "speed", "type", "price"};
        return db.query("ram", columns, null, null, null, null, null);
    }

    public Cursor getPsuData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"model", "wattage", "rating", "modular", "price"};
        return db.query("psu", columns, null, null, null, null, null);
    }
}
