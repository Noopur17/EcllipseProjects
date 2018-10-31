package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					Student tempStudent=new Student("Nupsi", "bhatt", "n@gmail.com");
					Student tempStudent1=new Student("keval", "bhatt", "k@gmail.com");
					Student tempStudent2=new Student("bhavana", "bhatt", "b@gmail.com");

					session.beginTransaction();
					
					System.out.println("saving the student");
					session.save(tempStudent);
					session.save(tempStudent1);
					session.save(tempStudent2);

					session.getTransaction().commit();
					
					System.out.println("done!!");
				}
				finally {
					factory.close();
				}
			}

	}


