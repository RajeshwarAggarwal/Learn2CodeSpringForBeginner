package com.learn2code.jdbc;

import com.learn2code.dao.entities.Course;
import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDeleteCourseMainApp {

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
            //start a transaction
            session.beginTransaction();

            // get a Course
            int theId=10;
            Course course = session.get(Course.class,theId);

            //delete a course
            if(null!=course){
                System.out.println("Deleting a course: "+course);
                session.remove(course);
            }

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            session.close();
            factory.close();
        }

    }

}
