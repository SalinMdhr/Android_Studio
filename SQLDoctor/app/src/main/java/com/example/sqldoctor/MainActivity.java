package com.example.sqldoctor;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView doctorListView;
    private HospitalDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doctorListView = findViewById(R.id.doctorListView);
        dbHelper = new HospitalDbHelper(this);

        // Insert doctor records
        insertDoctorRecords();

        // Display doctors with experience less than 5.5 years
        displayDoctorsWithLessExperience();
    }

    private void insertDoctorRecords() {
        dbHelper.insertDoctor(1, "Dr. John Doe", "Cardiology", 3.5);
        dbHelper.insertDoctor(2, "Dr. Jane Smith", "Neurology", 4.2);
        dbHelper.insertDoctor(3, "Dr. Sam Brown", "Orthopedics", 6.0);
        dbHelper.insertDoctor(4, "Dr. Lucy Liu", "Pediatrics", 2.8);
        dbHelper.insertDoctor(5, "Dr. Mike Ross", "Dermatology", 7.1);
    }

    private void displayDoctorsWithLessExperience() {
        ArrayList<String> doctorList = new ArrayList<>();
        Cursor cursor = dbHelper.getDoctorsWithLessExperience(5.5);

        int docId = cursor.getColumnIndex("Did");
        int docName = cursor.getColumnIndex("DName");
        int docExp = cursor.getColumnIndex("Experience");
        int docSpec = cursor.getColumnIndex("Specialization");

        while (cursor.moveToNext()) {
            int did = cursor.getInt(docId);
            String dName = cursor.getString(docName);
            String specialization = cursor.getString(docSpec);
            double experience = cursor.getDouble(docExp);
            doctorList.add("ID: " + did + ", Name: " + dName + ", Specialization: " + specialization + ", Experience: " + experience + " years");
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doctorList);
        doctorListView.setAdapter(adapter);
    }
}
