package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor=new Instructor("susan","Public","darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail=
					new InstructorDetail("kaku@gmail.com", "Luv2code!!");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();

		System.out.println("Saving Instructor:"+tempInstructor);
			session.save(tempInstructor);
			session.getTransaction().commit();
			
			System.out.println("done!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
