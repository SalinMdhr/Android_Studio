package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.first_num);
        EditText et2 = findViewById(R.id.second_num);
        Button btn = findViewById(R.id.add);
        TextView tv = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1, n2, res;
                n1 = Integer.parseInt(String.valueOf(et1.getText()));
                n2 = Integer.parseInt(String.valueOf(et2.getText()));
                res = n1 + n2;
                tv.setText("Result is " + res);
            }
        });

    }
}