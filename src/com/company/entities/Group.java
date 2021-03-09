package com.company.entities;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> studentList;
    private Teacher teacher;
    private int groupNumber;
    private char groupLetter;

    public Group(){
        teacher = new Teacher();
        studentList = new ArrayList<>();
    }

    public Group(int groupNumber, char groupLetter){
        this();
        this.groupLetter = groupLetter;
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setTeacherFirstName(String firstName){
        this.teacher.setFirstName(firstName);
    }

    public String getTeacherFirstName(){
        return this.teacher.getFirstName();
    }

    public void setTeacherLastName(String lastName){
        this.teacher.setLastName(lastName);
    }

    public String getTeacherLastName(){
        return this.teacher.getLastName();
    }

    public void setTeacherId(int id){ this.teacher.setId(id); }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public char getGroupLetter() {
        return groupLetter;
    }

    public void setGroupLetter(char groupLetter) {
        this.groupLetter = groupLetter;
    }
}
