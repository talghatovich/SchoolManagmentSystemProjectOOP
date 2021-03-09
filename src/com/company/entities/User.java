package com.company.entities;

// Contain common fields of student, teacher and parent classes

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String address;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public User(String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber) {
        this.id = Integer.parseInt(null);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setAddress(address);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setEmail(email);
    }

    public User(int id, String firstName, String lastName, boolean gender, String address, String dateOfBirth, String email, String phoneNumber) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setAddress(address);
        this.setDateOfBirth(dateOfBirth);
        this.setEmail(email);
        this.setEmail(email);
    }

    public void copy(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.gender = user.getGender();
        this.address = user.getAddress();
        this.dateOfBirth = user.getDateOfBirth();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.toLowerCase().substring(1);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.toLowerCase().substring(1);
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
