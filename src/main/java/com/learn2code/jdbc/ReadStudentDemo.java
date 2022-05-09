package com.learn2code.jdbc;

import com.learn2code.dao.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // use the session object to save the student object.

            // create a student object.
            System.out.println("Creating a new student object");
            Student tempStudent =  new Student("Kanhiya","Kumar","kanhiya.kumar@example.com");

            // start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.persist(tempStudent);

            // Commit transaction
            session.getTransaction().commit();

            //New Code

            // find out the student's id : primary key
            System.out.println("Saved Student.Generated Id "+tempStudent.getId());

            //now get a  new session to start a transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id : primary key

            Student myStudent = session.get(Student.class,tempStudent.getId());

            System.out.println("Get complete :"+myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
