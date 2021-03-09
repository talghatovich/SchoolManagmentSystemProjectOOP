package com.company.repositories.interfaces;

import com.company.entities.*;

public interface IAdminRepository {

    /**
     * Add teacher to data base
     * @param teacher Object of Teacher class with firstName, lastName,
     *                gender, salary, email, phoneNumber, dateOfBirth, address fields
     * @return Status message
     */
    boolean addTeacher(Teacher teacher);

    /**
     * Delete teacher from data base by id
     * @param id ID of teacher
     * @return Status message
     */
    boolean deleteTeacher(int id);

    /**
     * Add student to data base
     * @param student Object of Student class with firstName, lastName,
     *                gender, groupId, email, phoneNumber, dateOfBirth, address fields
     * @return Status message
     */
    boolean addStudent(Student student);

    /**
     * Delete student from data base by id
     * @param id ID of student
     * @return Status message
     */
    boolean deleteStudent(int id);

    /**
     * Add group to the data base
     * @param group Object of Group class with groupLetter groupNumber and groupTeacherId fields
     * @return Status message
     */
    boolean addClass(Group group);

    /**
     * Delete class from data base by id
     * @param id ID of class
     * @return Status message
     */
    boolean deleteClass(int id);

    /**
     * Add parent to data base
     * @param parent Object of Parent class with firstName, lastName,
     *                gender, email, phoneNumber, dateOfBirth, address fields
     * @return Status message
     */
    boolean addParent(Parent parent);

    /**
     * Delete parent from data base by id
     * @param id ID of parent
     * @return Status message
     */
    boolean deleteParent(int id);

    String[] getStudentLoginAndPassword(Student student);

    String[] getParentLoginAndPassword(Parent student);
}
