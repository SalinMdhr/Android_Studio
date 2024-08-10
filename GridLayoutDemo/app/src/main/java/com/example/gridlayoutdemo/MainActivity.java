package com.example.gridlayoutdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView g;
    String[] myArray = {"Lamborghini", "BMW M3 GTR", "Ford Mustang", "Bugati Veron", "Mercedes Benz", "Porsche", "Aston Martin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (GridView) findViewById(R.id.grid);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.layout_grid, R.id.tv1, myArray);
        g.setAdapter(arr);

    }
}