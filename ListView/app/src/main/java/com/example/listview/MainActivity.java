package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] myArray = {"Hero", "Honda", "Pulsar", "Yamaha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.myList);
        ArrayAdapter <String> arr = new ArrayAdapter<String>(this, R.layout.list_item, R.id.myText, myArray);
        l.setAdapter(arr);
    }
}