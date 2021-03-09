package com.company.repositories.interfaces;

import com.company.entities.Parent;
import com.company.entities.Student;

public interface IParentRepository {
    /**
     * Method return child object with personal information
     * @param parent Parent object to find student
     * @return Student object with personal information
     */
    Student getChild(Parent parent);
}
