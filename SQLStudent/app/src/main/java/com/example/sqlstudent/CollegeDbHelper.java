package com.example.sqlstudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CollegeDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "College";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Student";
    private static final String COLUMN_ROLL = "Roll";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_ADDRESS = "Address";

    public CollegeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ROLL + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertStudent(int roll, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLL, roll);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
