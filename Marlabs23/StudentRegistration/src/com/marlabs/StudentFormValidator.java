package com.marlabs;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("studentFormValidator")
public class StudentFormValidator implements Validator{

	
		@SuppressWarnings("unchecked")
		@Override
		public boolean supports(Class clazz)
		{
			return Student.class.isAssignableFrom(clazz);
		}

		@Override
		public void validate(Object model, Errors errors)
		{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName","required.studentName", "Name is required.");
		}
}
