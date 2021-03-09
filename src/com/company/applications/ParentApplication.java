package com.company.applications;

import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.repositories.ParentRepository;
import com.company.repositories.StudentRepository;

import java.util.InputMismatchException;

/*
    Extends from StudentApplication because ParentApplication repeat interaction with data base
    So, we only rewrote run method
*/

public class ParentApplication extends StudentApplication{

    private final Parent parent;

    public ParentApplication(IDB db, Parent parent){
        super(new StudentRepository(db), new ParentRepository(db).getChild(parent));
        this.parent = parent;
    }

    /**
     * Method to start application
     */
    public void run() {
        System.out.println("Welcome " +  parent.getFirstName() + " " + parent.getLastName());
        boolean exit = true;
        while (exit) {
            System.out.println("---------Select option: --------");
            System.out.println("|\t1. Get child information    |");
            System.out.println("|\t2. Get schedule             |");
            System.out.println("|\t3. Get marks of subject     |");
            System.out.println("|\t4. Get homework of subject  |");
            System.out.println("|\t5. Log out                  |");
            System.out.println("|\t0. Exit                     |");
            System.out.println("--------------------------------");
            System.out.print("| Select option(0-4): ");
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> this.getInformation();
                    case 2 -> this.getSubjectsInfo();
                    case 3 -> this.getMarkOfSubject();
                    case 4 -> this.getHomeworkOfSubject();
                    case 5 -> exit = false;
                    case 0 -> System.exit(0);
                    default -> System.out.println("WRONG INPUT");
                }
            } catch (InputMismatchException ex){
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
        }
        System.out.println("Good bye " + parent.getFirstName() + " " + parent.getLastName());
    }
}
