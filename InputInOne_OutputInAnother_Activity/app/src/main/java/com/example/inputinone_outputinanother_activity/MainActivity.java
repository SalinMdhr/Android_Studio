package com.example.inputinone_outputinanother_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.et1);
        EditText age = findViewById(R.id.et2);
        EditText email = findViewById(R.id.et3);
        Button btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = name.getText().toString();
                String s2 = age.getText().toString();
                String s3 = email.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("name", s1);
                i.putExtra("age", s2);
                i.putExtra("email", s3);
                startActivity(i);
            }
        });
    }
}