package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudent=session.createQuery("from Student").list();
			
			for(Student tempStudent:theStudent) {
				System.out.println(tempStudent);
			}
			
			session.getTransaction().commit();
			
			System.out.println("done!!");
		}
		finally {
			factory.close();
		}
	}

}
