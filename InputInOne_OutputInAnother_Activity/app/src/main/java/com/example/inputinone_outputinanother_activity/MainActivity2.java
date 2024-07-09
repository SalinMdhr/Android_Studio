package com.example.inputinone_outputinanother_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.receive);
        Intent i = getIntent();
        String s4 = i.getStringExtra("name");
        String s5 = i.getStringExtra("age");
        String s6 = i.getStringExtra("email");
        tv.setText("Name: " + s4 + "\nAge: " + s5 + "\nEmail: " + s6);
    }
}