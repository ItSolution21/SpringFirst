package com.example.pract6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pract6.model.Student;
import com.example.pract6.repository.StudentRepository;

@Controller
public class HomeController {

	private final StudentRepository repo;
	
	@Autowired
	public HomeController(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}
	
	@PostMapping("/welcome")
	public String well(Model model, Student st) {
		
		model.addAttribute("name", st.getName());
		System.out.println(st);
		repo.save(st);
		return "welcome";
	}
}
