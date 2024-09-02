package com.example.listofstudent;

public class Student {
    private int roll;
    private String name;
    private String address;

    public Student(int roll, String name, String address) {
        this.roll = roll;
        this.name = name;
        this.address = address;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

