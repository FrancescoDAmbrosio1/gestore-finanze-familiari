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

import it.myBudget.model.CategoriaSpesa;
import it.myBudget.repository.CategoriaSpesaRepository;

@Controller
@RequestMapping("/categorie")

public class CategorieController {
	
	@Autowired
	CategoriaSpesaRepository categoriaSpesaRepository;

	@GetMapping
	private String gestioneCategorie(Model model) {
		
		model.addAttribute("categoriaSpesa", new CategoriaSpesa());
		
		return "/categorie/generale-categorie";
	}
	
	@PostMapping("/spese/create")
	private String salvaCategorieDiSpesa(@Valid @ModelAttribute("categoriaSpesa") CategoriaSpesa categoriaSpesa,
			Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			return "/categorie/generale-categorie";
			
		}
		
		categoriaSpesaRepository.save(categoriaSpesa);
		
		return "redirect:/categorie";
	}
	
}
