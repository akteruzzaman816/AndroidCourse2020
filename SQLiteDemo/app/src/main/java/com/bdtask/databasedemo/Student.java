package com.bdtask.databasedemo;

public class Student {
    int id;
    String name;
    String Address;


    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        Address = address;
    }

    public Student(String name, String address) {
        this.name = name;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }




    public static final String STUDENT_TABLE     = "student";
    public static final String ID                = "id";
    public static final String STUDENT_NAME      = "name";
    public static final String STUDENT_ADDRESS   = "address";

    public static final String STUDENT_QUERY ="CREATE TABLE "+STUDENT_TABLE +"("
        +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
        +STUDENT_NAME+" TEXT, "
        +STUDENT_ADDRESS+" Text"
        +
        ")";











}
