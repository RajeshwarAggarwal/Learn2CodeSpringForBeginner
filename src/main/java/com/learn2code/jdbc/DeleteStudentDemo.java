package com.learn2code.jdbc;

import com.learn2code.dao.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            //Delete student
            System.out.println("Deleting student: "+myStudent);
            //session.delete(myStudent);

            System.out.println("Deleting Student with id=2");
            session.createQuery("delete from Student s where s.id=2").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
