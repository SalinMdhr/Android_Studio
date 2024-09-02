package com.example.sqlitedemo1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPass, etOldupdate, etNewUpdate, etDelete;
    MyDbAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.nameET);
        etPass = findViewById(R.id.passET);
        etOldupdate = findViewById(R.id.updateOldET);
        etNewUpdate = findViewById(R.id.updateNewET);
        etDelete = findViewById(R.id.deleteUserET);

        lv = findViewById(R.id.listViewid);

        adapter = new MyDbAdapter(this);

        Button addBtn = findViewById(R.id.addUserBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(v);
            }
        });

        Button viewVtn = findViewById(R.id.viewUserBtn);
        viewVtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewUser(v);
            }
        });

        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser(v);
            }
        });
        Button deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser(v);
            }
        });
    }

    public void addUser(View view) {
        String s1 = etName.getText().toString();
        String s2 = etPass.getText().toString();
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "input all fields", Toast.LENGTH_SHORT).show();
        } else {
            long id = adapter.insertData(s1, s2);
            if (id <= 0) {
                Toast.makeText(this, "unsuccessful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            etName.setText("");
            etPass.setText("");
        }
    }

    public void viewUser(View view) {
        String data = adapter.getData();
//        Toast.makeText(this, data + " ", Toast.LENGTH_SHORT).show();
        ArrayList<String> userList = new ArrayList<>();
        userList.add(data);
        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        lv.setAdapter(arr);
    }

    public void updateUser(View view) {
        String old = etOldupdate.getText().toString();
        String newU = etNewUpdate.getText().toString();
        if (old.isEmpty() || newU.isEmpty()) {
            Toast.makeText(this, "input all fields", Toast.LENGTH_SHORT).show();
        } else {
            int id = adapter.updateName(old, newU);
            if (id <= 0) {
                Toast.makeText(this, "unsuccessful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            etOldupdate.setText("");
            etNewUpdate.setText("");
        }
    }

    public void deleteUser(View view) {
        String del = etDelete.getText().toString();
        if (del.isEmpty()) {
            Toast.makeText(this, "input all fields", Toast.LENGTH_SHORT).show();
        } else {
            int id = adapter.delete(del);
            if (id <= 0) {
                Toast.makeText(this, "unsuccessful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            etDelete.setText("");
        }
    }
}