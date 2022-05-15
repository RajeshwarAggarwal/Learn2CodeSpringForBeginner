package com.learn2code.jdbc;

import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiDeleteMainApp {

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
            int theId=2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
            System.out.println("Found InstructorDetail: "+tempInstructorDetail);

            // delete the instructor.
            if(tempInstructorDetail!=null){
                System.out.println("Deleting tempInstructorDetail : "+tempInstructorDetail);
                session.delete(tempInstructorDetail); // Note : will also delete instructor object as well due to cascading.
            }

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            factory.close();
        }

    }

}
