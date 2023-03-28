package com.example.projekt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connect {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private Connect() {
    }
    public static Session openSession(){
        return factory.openSession();
    }
}
