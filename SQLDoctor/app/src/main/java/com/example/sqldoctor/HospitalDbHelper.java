package com.example.sqldoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HospitalDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Hospital";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Doctor";
    private static final String COLUMN_DID = "Did";
    private static final String COLUMN_DNAME = "DName";
    private static final String COLUMN_SPECIALIZATION = "Specialization";
    private static final String COLUMN_EXPERIENCE = "Experience";

    public HospitalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_DID + " INTEGER PRIMARY KEY, " +
                COLUMN_DNAME + " TEXT, " +
                COLUMN_SPECIALIZATION + " TEXT, " +
                COLUMN_EXPERIENCE + " REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertDoctor(int did, String dName, String specialization, double experience) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DID, did);
        values.put(COLUMN_DNAME, dName);
        values.put(COLUMN_SPECIALIZATION, specialization);
        values.put(COLUMN_EXPERIENCE, experience);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getDoctorsWithLessExperience(double experience) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_EXPERIENCE + " < ?";
        String[] selectionArgs = {String.valueOf(experience)};
        return db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
    }
}

