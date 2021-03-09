package com.company.entities;

public class Teacher extends User{
    private int salary;

    public Teacher(){
    }

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Teacher(String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber, int salary){
        super(firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
        this.salary = salary;
    }

    public Teacher(int id, String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber, int salary){
        super(id, firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
