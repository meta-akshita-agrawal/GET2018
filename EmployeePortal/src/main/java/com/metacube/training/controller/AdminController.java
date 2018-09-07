package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.*;
import com.metacube.training.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password) {
		return new ModelAndView("admin/dashboard","username",username);
	}
	
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/projects")
	public String getAllProjects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}
	
	@GetMapping("/projects/add")
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/projectForm";
	}
	
	@GetMapping("/projects/edit")
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/projectForm";
	}
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project) {
		if(project!=null && project.getId()==0) {
			projectService.createProject(project);
		}
		else {
			projectService.updateProject(project);
		}
		
		return "redirect:/admin/projects";
	}
	
	@GetMapping("/admin/delete")
	public String deleteProject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/jobs")
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "admin/jobs";
	}
	
	@GetMapping("/jobs/add")
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/addForm";
	}
	
	@PostMapping("/jobs/add")
	public String addJob(@ModelAttribute("job") Job job) {
		jobService.createJob(job);
		return "redirect:/admin/jobs";
	}
	
}
