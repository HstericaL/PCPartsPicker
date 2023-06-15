package com.partsbuilder.pcbuildproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_pcparts.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create processor table
        db.execSQL("CREATE TABLE processor(" +
                "processor_brand TEXT," +
                "processor_model TEXT," +
                "socket_generation TEXT," +
                "cores_threads TEXT," +
                "baseclock_ghz REAL," +
                "tdp_w INTEGER," +
                "msrp_php REAL)");

        // create motherboard table
        db.execSQL("CREATE TABLE motherboard(" +
                "motherboard_brand TEXT," +
                "motherboard_model TEXT," +
                "socket_generation TEXT," +
                "price REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS processor");
        db.execSQL("DROP TABLE IF EXISTS motherboard");
        onCreate(db);
    }

    public void resetDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("processor", null, null);
        db.delete("motherboard", null, null);
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

    public Cursor getProcessorData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"processor_brand", "processor_model"};
        return db.query("processor", columns, null, null, null, null, null);
    }

    public Cursor getMotherboardData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"motherboard_brand", "motherboard_model"};
        return db.query("motherboard", columns, null, null, null, null, null);
    }
}
