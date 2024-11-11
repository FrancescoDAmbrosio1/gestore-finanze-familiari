package it.myBudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spese")

public class SpeseController {
	
	@GetMapping
	private String gestioneSpese(Model model) {
		
		return "/spese/speseHome";
	}

}
