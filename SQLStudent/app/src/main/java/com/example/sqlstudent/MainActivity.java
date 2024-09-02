package com.example.sqlstudent;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView studentListView;
    private CollegeDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.studentListView);
        dbHelper = new CollegeDbHelper(this);

        // Insert student records
        insertStudentRecords();

        // Display student registration
        displayStudentRegistration();
    }

    private void insertStudentRecords() {
        dbHelper.insertStudent(1, "John Doe", "123 Main St");
        dbHelper.insertStudent(2, "Jane Smith", "456 Elm St");
        dbHelper.insertStudent(3, "Sam Brown", "789 Oak St");
        dbHelper.insertStudent(4, "Lucy Liu", "321 Pine St");
        dbHelper.insertStudent(5, "Mike Ross", "654 Maple St");
    }

    private void displayStudentRegistration() {
        ArrayList<String> studentList = new ArrayList<>();
        Cursor cursor = dbHelper.getAllStudents();
        int Rollid = cursor.getColumnIndex("Roll");
        int SName = cursor.getColumnIndex("Name");
        int SAddress = cursor.getColumnIndex("Address");

        while (cursor.moveToNext()) {
            int roll = cursor.getInt(Rollid);
            String name = cursor.getString(SName);
            String address = cursor.getString(SAddress);
            studentList.add("Roll: " + roll + ", Name: " + name + ", Address: " + address);
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        studentListView.setAdapter(adapter);
    }
}
