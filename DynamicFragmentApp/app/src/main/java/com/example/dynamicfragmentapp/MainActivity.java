package com.example.dynamicfragmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button redBtn = findViewById(R.id.redFrag);
        Button greenBtn = findViewById(R.id.greenFrag);
        TextView pt = findViewById(R.id.placeholderText);

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pt.setVisibility(View.GONE);
                loadFragment(new RedFragment());
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pt.setVisibility(View.GONE);
                loadFragment(new GreenFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragmentContainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}