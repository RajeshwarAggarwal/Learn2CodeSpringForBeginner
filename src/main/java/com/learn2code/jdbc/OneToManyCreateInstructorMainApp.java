package com.learn2code.jdbc;

import com.learn2code.dao.entities.Course;
import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class OneToManyCreateInstructorMainApp {

    public static void main(String[] args) {

        // create session factory
        SessionFactory  factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            // create a tempInstructor
            Instructor tempInstructor = new Instructor("Susan","public","susan.pub@example.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/videoGame","Video Gammer");

            // associate the object.
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving the instructor "+tempInstructor);
            session.persist(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            session.close();
            factory.close();
        }

    }

}
