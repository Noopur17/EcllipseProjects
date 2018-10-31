package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	public ModelAndView display() {
		
		String data = "Hello!";
		
		return new ModelAndView("welcome", "message", data);
	}

}
