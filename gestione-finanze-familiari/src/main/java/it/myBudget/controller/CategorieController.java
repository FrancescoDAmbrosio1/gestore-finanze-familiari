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

import it.myBudget.model.CategoriaIntroiti;
import it.myBudget.model.CategoriaSpesa;
import it.myBudget.repository.CategoriaIntroitiRepository;
import it.myBudget.repository.CategoriaSpesaRepository;
import it.myBudget.repository.IconaRepository;

@Controller
@RequestMapping("/categorie")

public class CategorieController {
	
	@Autowired
	CategoriaSpesaRepository categoriaSpesaRepository;
	
	@Autowired
	CategoriaIntroitiRepository categoriaIntroitiRepository;
	
	@Autowired
	IconaRepository iconaRepository;

	@GetMapping
	private String gestioneCategorie(Model model) {
		
		model.addAttribute("categoriaSpesa", new CategoriaSpesa());
		
		model.addAttribute("categoriaIntroiti", new CategoriaIntroiti());
		
		model.addAttribute("iconaList", iconaRepository.findAll());
		
		return "/categorie/generale-categorie";
	}
	
	@PostMapping("/spese/create")
	private String salvaCategorieDiSpesa(@Valid @ModelAttribute("categoriaSpesa") CategoriaSpesa categoriaSpesa,
			Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("errore nella creazione della categoria");
			
			return "/categorie/generale-categorie";
			
		}
		
		categoriaSpesaRepository.save(categoriaSpesa);
		
		return "redirect:/categorie";
	}
	
	@PostMapping("/introiti/create")
	private String salvaCategorieDiIntroiti(@Valid @ModelAttribute("categoriaIntroiti") CategoriaIntroiti categoriaIntroiti,
			Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			return "/categorie/generale-categorie";
			
		}
		
		categoriaIntroitiRepository.save(categoriaIntroiti);
		
		return "redirect:/categorie";
	}
}
