package com.marlabs;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentsDAO {
	@Autowired
	private static SessionFactory sessionFactory;
	
	public Student getById(int id)
	{
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		return criteria.list();
	}
	
	public static int save(Student student)
	{
		return (Integer) sessionFactory.getCurrentSession().save(student);
	}
	
}
