package com.company.repositories.interfaces;

import com.company.entities.Parent;
import com.company.entities.Student;

public interface IUserRepository {

    /**
     * Method to log in as student
     * @param login Login of student account
     * @param password Password of account
     * @return Object of student with personal information if login and password are correct. Otherwise return null
     */
    Student loginStudent(String login, String password);

    /**
     * Mathod to log in as parent
     * @param login Login of parent account
     * @param password Password of account
     * @return Object of parent with personal information if login and password are correct. Otherwise return null
     */
    Parent loginParent(String login, String password);
}
