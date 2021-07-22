package com.jdbc;

import com.jdbc.entity.Course;
import com.jdbc.entity.Instructor;
import com.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor =
                    new Instructor("susan", "Darby", "susan@jdbc.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "www.youtube.com",
                            "gaming");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            //save ;also saves detail
            //because of cascade
            System.out.println("saving"+tempInstructor);
            session.save(tempInstructor);


            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}
