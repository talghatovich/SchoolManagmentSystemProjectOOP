package com.company.entities;

import java.util.List;

public class Subject {
    private String subjectName;
    private Teacher teacher;
    private String day;
    private String startTime;
    private String endTime;
    private List<Group> groups;

    public Subject(){
        teacher = new Teacher();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public void setTeacherLastName(String lastName){
        this.teacher.setLastName(lastName);
    }

    public String getTeacherFirstName(){
        return this.teacher.getFirstName();
    }

    public String getTeacherLastName(){
        return this.teacher.getLastName();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
