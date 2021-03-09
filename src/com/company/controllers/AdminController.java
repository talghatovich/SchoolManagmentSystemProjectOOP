package com.company.controllers;

import com.company.entities.Group;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.repositories.interfaces.IAdminRepository;

public class AdminController {
    private final IAdminRepository adminRepository;

    public AdminController(IAdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    /**
     * Add teacher to data base
     * @param teacher Object of Teacher class with firstName, lastName,
     *                gender, salary, email, phoneNumber, dateOfBirth, address fields
     * @return Status message
     */
    public String addTeacher(Teacher teacher){
        return adminRepository.addTeacher(teacher) ? "Something went wrong" : "Teacher was added successfully";
    }

    /**
     * Delete teacher from data base by id
     * @param id ID of teacher
     * @return Status message
     */
    public String deleteTeacher(int id){
        return adminRepository.deleteTeacher(id) ? "Something went wrong" : "Teacher was removed";
    }

    /**
     * Add student to data base
     * @param student Object of Student class with firstName, lastName,
     *                gender, groupId, email, phoneNumber, dateOfBirth, address fields
     * @return Status message, login and password
     */
    public String addStudent(Student student){
        boolean result = adminRepository.addStudent(student);
        if(!result){
            String[] loginAndPassword = adminRepository.getStudentLoginAndPassword(student);
            return "Student was added successfully\n" + "Login: " + loginAndPassword[0] + "\nPassword: " + loginAndPassword[1];
        }
        return "Something went wrong";
    }

    /**
     * Delete student from data base by id
     * @param id ID of student
     * @return Status message
     */
    public String deleteStudent(int id){
        return adminRepository.deleteStudent(id) ? "Something went wrong" : "Student was removed";
    }

    /**
     * Add group to the data base
     * @param group Object of Group class with groupLetter groupNumber and groupTeacherId fields
     * @return Status message
     */
    public String addClass(Group group){
        return adminRepository.addClass(group) ? "Something went wrong" : "Class was added successfully";
    }

    /**
     * Delete class from data base by id
     * @param id ID of class
     * @return Status message
     */
    public String deleteClass(int id){
        return adminRepository.deleteClass(id) ? "Something went wrong" : "Class was removed";
    }

    /**
     * Add parent to data base
     * @param parent Object of Parent class with firstName, lastName,
     *                gender, email, phoneNumber, dateOfBirth, address fields
     * @return Status message, login and password
     */
    public String addParent(Parent parent){
        boolean result = adminRepository.addParent(parent);
        if(!result){
            String[] loginAndPassword = adminRepository.getParentLoginAndPassword(parent);
            return "Parent was added successfully\n" + "Login: " + loginAndPassword[0] + "\nPassword: " + loginAndPassword[1];
        }
        return "Something went wrong";
    }

    /**
     * Delete parent from data base by id
     * @param id ID of parent
     * @return Status message
     */
    public String deleteParent(int id){
        return adminRepository.deleteParent(id) ? "Something went wrong" : "Parent was removed";
    }

}
