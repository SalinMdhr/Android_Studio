package com.example.listofstudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentDetailFragment extends Fragment {

    private TextView tvRoll, tvName, tvAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_detail, container, false);

        tvRoll = view.findViewById(R.id.tvRoll);
        tvName = view.findViewById(R.id.tvName);
        tvAddress = view.findViewById(R.id.tvAddress);

        return view;
    }

    public void displayStudentDetails(Student student) {
        if (student != null) {
            tvRoll.setText("Roll: " + student.getRoll());
            tvName.setText("Name: " + student.getName());
            tvAddress.setText("Address: " + student.getAddress());
        }
    }
}
