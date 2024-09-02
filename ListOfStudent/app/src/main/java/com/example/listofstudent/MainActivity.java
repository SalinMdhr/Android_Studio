package com.example.listofstudent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView studentListView;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.studentListView);

        // Initialize the student list
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "John Doe", "123 Main St"));
        studentList.add(new Student(2, "Jane Smith", "456 Elm St"));
        studentList.add(new Student(3, "Sam Brown", "789 Oak St"));

        // Extract student names for ListView display
        ArrayList<String> studentNames = new ArrayList<>();
        for (Student student : studentList) {
            studentNames.add(student.getName());
        }

        // Set up the ListView with student names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentNames);
        studentListView.setAdapter(adapter);

        // Handle item clicks to show student details in the fragment
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student selectedStudent = studentList.get(position);

                StudentDetailFragment fragment = new StudentDetailFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragment);
                transaction.commit();

                fragment.displayStudentDetails(selectedStudent);
            }
        });
    }
}
