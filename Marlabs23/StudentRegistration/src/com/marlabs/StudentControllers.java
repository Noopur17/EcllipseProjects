package com.marlabs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentControllers {

	@Autowired
	private StudentsDAO studentDAO;
	
	@Autowired
	private StudentFormValidator validator;
	
	
	@RequestMapping("/viewAllStudents")
	public ModelAndView getAllStudents()
	{
		ModelAndView mav = new ModelAndView("showStudents");
		List<Student> students = studentDAO.getAllStudents();
		mav.addObject("SEARCH_CONTACTS_RESULTS_KEY", students);
		return mav;
	}
	
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("saveStudents");
Student s=new Student();
		mav.getModelMap().put("saveStudents", s);
		return mav;
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String create(@ModelAttribute("saveStudents")Student s, BindingResult result, SessionStatus status)
	{
		System.out.println(s.getStudentName());
		validator.validate(s, result);
		if (result.hasErrors()) 
		{	
			System.out.println("in if has error");
			return "home";
		}
		System.out.println("calling dao in savestudent");
		StudentsDAO.save(s);
		status.setComplete();
		return "saveStudents";
	}
}
