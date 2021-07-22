package com.jdbc;

import com.jdbc.entity.Course;
import com.jdbc.entity.Instructor;
import com.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();
            int id=1;
            Instructor instructor=session.get(Instructor.class,id);

            System.out.println(instructor);

            System.out.println(instructor.getCourses());



            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}
