package com.metacube.training.controller;

import java.util.List;

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
	
	@GetMapping("/dashboard")
	public String getDashboard(){
		return "admin/dashboard";
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
		return "admin/addEditProject";
	}
	
	@GetMapping("/projects/edit")
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/addEditProject";
	}
	
	@PostMapping("/projects")
	public String saveProject(@ModelAttribute("project") Project project) {
		if(project!=null && project.getId()==0) {
			projectService.createProject(project);
		}
		else {
			projectService.updateProject(project);
		}
		
		return "redirect:/admin/projects";
	}
	
	@GetMapping("/projects/delete")
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
		return "admin/addJob";
	}
	
	@PostMapping("/jobs")
	public String addJob(@ModelAttribute("job") Job job) {
		jobService.createJob(job);
		return "redirect:/admin/jobs";
	}
	
	
	@Autowired
	SkillService skillService;
	
	
	@GetMapping("/skills")
	public String getAllSkills(Model model){
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}
	
	@GetMapping("/skills/add")
	public String addSkill(Model model){
		model.addAttribute("skill", new Skill());
		return "admin/addSkill";
	}
	
	@PostMapping("/skills")
	public String addSkill(@ModelAttribute("skill") Skill skill){
		skillService.createSkill(skill);
		return "redirect:/admin/skills";
	}
	
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeSkillsService employeeSkillsService;
	
	@GetMapping("/employee")
	public String getAllEmployee(Model model){
		model.addAttribute("employeeList", employeeService.getAllEmployee());
		return "admin/employee";
	}
	
	@GetMapping("/employee/add")
	public String addEmployee(Model model){
		List<Skill> skillsList = skillService.getAllSkills();
		String[] skills = new String[10];
		model.addAttribute("employee", new Employee());
		model.addAttribute("skillsList",skillsList);
		model.addAttribute("skills", skills);
		return "admin/addEditEmployee";
	}
	
	@GetMapping("/employee/edit")
	public String editEmployee(Model model, @RequestParam("id") int id){
		List<Skill> skillsList = skillService.getAllSkills();
		String[] skills = new String[10];
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("skillsList",skillsList);
		model.addAttribute("skills", skills);
		
		return "admin/addEditEmployee";
	}
	
	@PostMapping("/employee")
	public String addEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("skills") String[] skills){
		
		
		
		if(employee!=null && employee.getEmployeeID()==0) {
			employeeService.createEmployee(employee);
			
		}
		else {
			employeeService.updateEmployee(employee);
			employeeSkillsService.deleteSkillsByEmployeeID(employee.getEmployeeID());
			
		}
		
		employeeSkillsService.insertSkillsForEmployeeID(skills, employeeService.getEmployeeByEmail(employee.getEmailID()).getEmployeeID());
		
		
		
		return "redirect:/admin/employee";
		
	}
	
	@GetMapping("/employee/search")
	public String searchEmployee(Model model){
		model.addAttribute("employee", new Employee());
		return "/admin/search";
	}
	
	@PostMapping("/employee/search")
	public String searchEmployee(Model model,@ModelAttribute("employee") Employee employee, @RequestParam("skillName") String skillName){
		model.addAttribute("employeeList", employeeSkillsService.findBySkillName(skillName));
		return "/admin/employee";
	}

	
	@GetMapping("/logout")
	public String logout(){
		return "admin/dashboard";
	}
}
