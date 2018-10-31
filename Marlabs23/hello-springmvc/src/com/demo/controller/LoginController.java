package com.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginForm;

@Controller
//@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("sayhello")
	public ModelAndView sampleAction() {
		
		String message = "A demo message for Spring MVC!";
		
		return new ModelAndView("welcome", "welcomeMessage", message);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginForm(Map model) {
		
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		
		return "login";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLoginForm(Map model, @Valid LoginForm loginForm,BindingResult result) {
		
		if(result.hasErrors())
		{
			return "login";
		}
		
		else if(loginForm.getUsername().equals("Admin") && loginForm.getPassword().equals("password"))
			return "dashboard";
		
		return "error";
	}

}
