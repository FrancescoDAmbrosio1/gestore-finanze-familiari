package it.myBudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class DashboardController {
	
	@GetMapping
	private String home(Model model) {
		
		return "/home";
	}
	
	@GetMapping("/dashboard")
	private String dashboard(Model model) {
		
		return "/dashboard";
	}
	

}
