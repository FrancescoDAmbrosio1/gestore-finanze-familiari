package it.myBudget.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myBudget.model.Spesa;
import it.myBudget.repository.SpesaRepository;
import it.myBudget.repository.UtenteRepository;

@Controller
@RequestMapping("/spese")

public class SpeseController {

	@Autowired
	private SpesaRepository spesaRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@GetMapping
	private String gestioneSpese(Model model) {
		
		model.addAttribute("spesa", new Spesa());
		
		model.addAttribute("userList", utenteRepository.findAll());
		
		return "/spese/generale-spese";
	}
	
	
//	@GetMapping("/create")
//	public String creaNuovaSpesa(Model model) {
//		
//		model.addAttribute("spesa", new Spesa());
//		
//		return "/spese/generale-spese";
//	}
	
	@PostMapping("/create")
	public String salvaNuovaSpesa(@Valid @ModelAttribute("spesa") Spesa spesa, Model model,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			return"redirect:/spese";
		}
		
		spesaRepository.save(spesa);
		
		return "redirect:/spese";
	}

}
