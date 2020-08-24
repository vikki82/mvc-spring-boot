package com.awz.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.awz.student.modal.Student;
import com.awz.student.repository.StudentRepository;

@Controller
public class UserControler {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/") // view first page
	public String showSignUpForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "index";
	}
	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "list";
	}

	@PostMapping("add")
	public String addStudent(@ModelAttribute("student") Student student, @Validated BindingResult result) {
		if (result.hasErrors()) {
			return "list";
		}

		studentRepository.save(student);
		return "redirect:list";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {

		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.findAll());
		return "list";
	}

}
