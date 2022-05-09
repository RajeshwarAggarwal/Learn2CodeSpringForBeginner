package com.learn2code.jdbc;

import com.learn2code.dao.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
                buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // start a transaction
            session.beginTransaction();

            //Query a student

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the Student
            theStudents.stream().forEach(System.out::println);

            // final all students with last name : Aggarwal

            theStudents=session.createQuery("from Student s where s.lastName='Aggarwal'").getResultList();
            System.out.println("Student with lastName = Aggarwal is ");
            theStudents.stream().forEach(System.out::print);


            // final all students with first name : Krishu last name : Aggarwal

            theStudents=session.createQuery("from Student s where s.lastName='Aggarwal' OR s.firstName='Krishu'").getResultList();

            System.out.println("Student with firstName =Krishu and lastName=Aggarwal ");
            theStudents.stream().forEach(System.out::println);

            // find all students with email like 'example.com'
            theStudents=session.createQuery("from Student s where s.email like '%example.com'").getResultList();
            System.out.println("Student with email Id like 'example.com");
            theStudents.stream().forEach(System.out::println);

            // Commit transaction
            session.getTransaction().commit();



            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
