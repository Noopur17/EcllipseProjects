package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating a new student object ");
			Student tempStudent=new Student("ripli", "bhatt", "r@gmail.com");
			session.beginTransaction();
			
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id:"+tempStudent.getId());
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with the id:"+tempStudent.getId());
			
			Student mystudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete:"+mystudent);
			
			session.getTransaction().commit();
			
			System.out.println("done!!");
		}
		finally {
			factory.close();
		}
	}

}
