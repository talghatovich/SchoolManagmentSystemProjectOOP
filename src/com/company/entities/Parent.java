package com.company.entities;

public class Parent extends User{
    public Parent(){
    }

    public Parent(String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber) {
        super(firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
    }

    public Parent(int id, String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber) {
        super(id, firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
    }
}
