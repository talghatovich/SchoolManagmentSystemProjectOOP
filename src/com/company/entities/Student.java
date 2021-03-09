package com.company.entities;

public class Student extends User{
    private int groupId;

    public Student(){
    }

    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber, int groupId){
        super(firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
        this.groupId = groupId;
    }

    public Student(int id, String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber, int groupId){
        super(id, firstName, lastName, gender, address, dateOfBirth, email, phoneNumber);
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString(){
        return "First name: " + super.getFirstName() +
                "\nLast name: " + super.getLastName() +
                "\nGender: " + (super.getGender() ? "Male" : "Female") +
                "\nAddress: " + super.getAddress() +
                "\nDate of birth: " + super.getDateOfBirth() +
                "\nEmail: " + super.getEmail() +
                "\nPhone number: " + super.getPhoneNumber();
    }
}
