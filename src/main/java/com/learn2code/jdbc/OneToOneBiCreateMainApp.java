package com.learn2code.jdbc;

import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiCreateMainApp {

    public static void main(String[] args) {

        // create session factory
        SessionFactory  factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            // get the tempInstructor details object
            int theId = 2;
            System.out.println("Getting the Instructor details with Id : "+theId);
            InstructorDetail tempInstructorDetails = session.get(InstructorDetail.class,theId);
            System.out.println("TempInstructorDetails :"+tempInstructorDetails);

            //
            System.out.printf("Instructor details is :"+tempInstructorDetails.getInstructor());

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }catch (Exception e ) {
            e.printStackTrace();
        }
        finally{
            session.close();
            factory.close();
        }

    }

}
