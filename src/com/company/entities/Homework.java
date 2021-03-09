package com.company.entities;

public class Homework {
    private String subjectName;
    private String deadline;
    private String description;

    public Homework(){
    }

    public Homework(String subjectName, String deadline, String description) {
        this.subjectName = subjectName;
        this.deadline = deadline;
        this.description = description;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

