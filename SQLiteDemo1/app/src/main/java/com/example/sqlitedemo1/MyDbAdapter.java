package com.example.sqlitedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDbAdapter {
    myDbHelper myHelper;

    public MyDbAdapter(Context context) {
        myHelper = new myDbHelper(context);
    }

    public long insertData(String name, String password) {
        SQLiteDatabase dbb = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, password);
        return dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
    }

    public String getData() {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.MyPASSWORD};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();

        int indexUID = cursor.getColumnIndex(myDbHelper.UID);
        int indexName = cursor.getColumnIndex(myDbHelper.NAME);
        int indexPassword = cursor.getColumnIndex(myDbHelper.MyPASSWORD);

        while (cursor.moveToNext()) {
            if (indexUID != -1 && indexName != -1 && indexPassword != -1) {
                int cid = cursor.getInt(indexUID);
                String name = cursor.getString(indexName);
                String password = cursor.getString(indexPassword);
                buffer.append(cid + " " + name + " " + password + "\n");
            }
        }
        cursor.close();
        return buffer.toString();
    }

    public int delete(String uname) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String[] whereArgs = {uname};

        return db.delete(myDbHelper.TABLE_NAME, myDbHelper.NAME + "= ?", whereArgs);
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, newName);
        String[] whereArgs = {oldName};

        return db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.NAME + "= ?", whereArgs);
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "sqlDemo1";
        protected static final String TABLE_NAME = "myTable";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String MyPASSWORD = "Password";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME + " VARCHAR(255)," + MyPASSWORD + " VARCHAR(225));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Toast.makeText(context, e + "", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
