package com.learn2code.jdbc;

import com.learn2code.dao.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            int studentId=1;

            session.beginTransaction();

            //retrieve student based on the id : primary key
            System.out.println("\n Getting student with id: "+studentId);

            Student myStudent = session.get(Student.class,studentId);

            System.out.println("Get complete :"+myStudent);

            //Updating student name
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();

            // New Code
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating all student for email");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
