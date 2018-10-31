package com.joseph.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseph.dao.StudentDAO;
import com.joseph.model.Student;
import com.joseph.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentdao;

	@Transactional
	public void add(Student student) {

		studentdao.add(student);
	}

	@Transactional
	public void edit(Student student) {
		studentdao.edit(student);
	}

	@Transactional
	public void delete(int studentId) {
		studentdao.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentdao.getStudent(studentId);
	}

	@Transactional
	public List getAllStudent() {
		return studentdao.getAllStudent();
	}

}
