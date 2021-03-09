package com.company;

import com.company.applications.Application;
import com.company.database.Postgres;
import com.company.database.interfaces.IDB;
import com.company.repositories.UserRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new Postgres();
        UserRepository userRepository = new UserRepository(db);
        Application app = new Application(userRepository);
        app.run();
    }
}
