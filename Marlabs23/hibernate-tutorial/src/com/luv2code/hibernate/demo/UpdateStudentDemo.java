package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
				int studentId=1;
						
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with the id:"+studentId);
			
			Student mystudent=session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			mystudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			System.out.println("done!!");
		}
		finally {
			factory.close();
		}
	}

}
