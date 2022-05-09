package com.learn2code.jdbc;

import com.learn2code.dao.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // use the session object to save the student object.

            // create a student object.
            System.out.println("Creating a 3 student object");
            Student tempStudent1 =  new Student("Karishma","Kapoor","KA@example.com");
            Student tempStudent2 =  new Student("Rajeshwar","Aggarwal","rajeshwar.aggarwal@example.com");
            Student tempStudent3 =  new Student("Krishu","goyal","kgoyal@example.com");
            // start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            session.persist(tempStudent1);
            session.persist(tempStudent2);
            session.persist(tempStudent3);
            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
