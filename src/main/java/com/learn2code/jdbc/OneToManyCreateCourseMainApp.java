package com.learn2code.jdbc;

import com.learn2code.dao.entities.Course;
import com.learn2code.dao.entities.Instructor;
import com.learn2code.dao.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreateCourseMainApp {

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

            // get a Instructor
            int theId=3;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            // Create a course
            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The PinBall MasterClass");

            // add the instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            //save the instructor
            System.out.println("Saving the courses in DB");
            session.persist(tempCourse1);
            session.persist(tempCourse2);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");

        }finally{
            session.close();
            factory.close();
        }

    }

}
