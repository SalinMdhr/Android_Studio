package com.example.longclicklistenerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Action Listener for single click btn
        b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t =  (TextView) findViewById(R.id.tv2);
                t.setText("On Click Event Activated");
            }
        });

        //Actionlistener for long click btn
        b = (Button) findViewById(R.id.btn2);
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v){
                t = (TextView) findViewById(R.id.tv3);
                t.setText("Long Click Event Activated");
                return false;
            }
        });

    }
}