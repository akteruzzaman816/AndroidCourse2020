package com.bdtask.recyclerviewdemo;

public class Student {

    private String name;
    private int phone;
    private String address;

    public Student(String name, int phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
