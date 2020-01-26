package com.devansh1497.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devansh1497.flightreservation.entities.User;
import com.devansh1497.flightreservation.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	
	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
	}
	
	@PostMapping("/login")
	//"email" and password will map/get the fields specified in the form(with the same name).
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) return "findFlights";
		else modelMap.addAttribute("msg", "Invalid username or password. Please try again");
		return "login/login";
	}
	
}
