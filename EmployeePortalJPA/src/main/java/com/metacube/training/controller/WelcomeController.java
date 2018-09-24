package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	@GetMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting", "Welcome");
		return "welcome";
	}
	
	@GetMapping("/login")
	public ModelAndView login(@RequestParam(value="error", required=false) String error){
		ModelAndView model = new ModelAndView();
		if(error!=null){
			model.addObject("error","Invalid username and password");
		}
		model.setViewName("login");
		return model;
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(HttpServletRequest req){
		if (req.isUserInRole("ROLE_ADMIN")){
			return "/admin/dashboard";
		}
		return "/employee/dashboard";
	}
}
