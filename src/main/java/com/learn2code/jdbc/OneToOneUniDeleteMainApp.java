package com.learn2code.jdbc;

import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class OneToOneUniDeleteMainApp {

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

            //get the instructor by primary key
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);
            System.out.println("Found Instructor: "+tempInstructor);

            // delete the instructor.
            if(tempInstructor!=null){
                System.out.println("Deleting tempInstructor : "+tempInstructor);
                session.delete(tempInstructor); // Note : will also delete instructorDetails object as well due to cascading.
            }

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            factory.close();
        }

    }

}
