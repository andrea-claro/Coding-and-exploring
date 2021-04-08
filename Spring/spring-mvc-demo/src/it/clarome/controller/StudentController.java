package it.clarome.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.clarome.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm") 
	public String showForm(Model theModel) { 

	    Student student = new Student();
	 
	    theModel.addAttribute("student", student); 
	    theModel.addAttribute("countryOptions", countryOptions); 

	    return "student-form"; 
	}

	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println("Student: "+student);
		return "student-confirmation";
	}
}
