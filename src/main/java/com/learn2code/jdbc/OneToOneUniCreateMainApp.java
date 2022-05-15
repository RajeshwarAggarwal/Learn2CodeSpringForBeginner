package com.learn2code.jdbc;

import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniCreateMainApp {

    public static void main(String[] args) {

        // create session factory
        SessionFactory  factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            // create the object
            Instructor tempInstructor = new Instructor("Rajeshwar","Aggarwal","rajeshwar.aggarwal@example.com");

            InstructorDetail tempInstructorDetails = new InstructorDetail("http://learn2Code/youtube","learn 2 code !!");

            // associate the object.
            tempInstructor.setInstructorDetail(tempInstructorDetails);

            //start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving Instructor.." +tempInstructor);
            session.persist(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            factory.close();
        }

    }

}
