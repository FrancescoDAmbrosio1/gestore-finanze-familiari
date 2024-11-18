package it.myBudget.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myBudget.model.CategoriaIntroiti;
import it.myBudget.model.CategoriaSpesa;
import it.myBudget.repository.CategoriaIntroitiRepository;
import it.myBudget.repository.CategoriaSpesaRepository;
import it.myBudget.repository.IconaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorie")

public class CategorieController {
	
	@Autowired
	CategoriaSpesaRepository categoriaSpesaRepository;
	
	@Autowired
	CategoriaIntroitiRepository categoriaIntroitiRepository;
	
	@Autowired
	IconaRepository iconaRepository;

	boolean erroriInserimento;
	
	boolean inserimentoCorretto;
	
	String nomeCategoriaInserita;
	
	@GetMapping
	public String gestioneCategorie(Model model) {
		
		model.addAttribute("listaCategorie", categoriaSpesaRepository.findAll());
		
		model.addAttribute("categoriaSpesa", new CategoriaSpesa());
		
//		model.addAttribute("categoriaIntroiti", new CategoriaIntroiti());
		
		model.addAttribute("iconaList", iconaRepository.findAll());
		
		erroriInserimento = false;
		
		model.addAttribute("erroriInserimento", erroriInserimento);
		
		model.addAttribute("inserimentoCorretto", inserimentoCorretto);
		
		model.addAttribute("nomeCategoriaInserita", nomeCategoriaInserita);
		
		return "/categorie/generale-categorie";
	}
	
	
	@PostMapping("/create")
	public String salvaCategorieDiSpesa(@Valid @ModelAttribute("categoriaSpesa") CategoriaSpesa categoriaSpesa,
			BindingResult bindingResult, Model model) {
		

		model.addAttribute("iconaList", iconaRepository.findAll());

		
		if(categoriaSpesa.getTipo() == null) {
			bindingResult.addError(new ObjectError("categoriaSpesa.tipo",
							"Selezionare se categoria di Spesa o di Introito"));
			
		}
		
		if(categoriaSpesa.getIcona() == null) {
			bindingResult.addError(new ObjectError("categoriaSpesa.icona", 
							"Scegliere un icona da assegnare alla categoria"));
		}
		
		
//		List<ObjectError> bindingList = bindingResult.getAllErrors();
//		
//		System.out.println("lista errori : " + bindingList);
		
		if(bindingResult.hasErrors()) {
			
			erroriInserimento = true;
			
			model.addAttribute("erroriInserimento", erroriInserimento);
			
			return "/categorie/generale-categorie";
			
		}
		
		categoriaSpesaRepository.save(categoriaSpesa);
		
		inserimentoCorretto = true;
		
		nomeCategoriaInserita = categoriaSpesa.getNome();
		
		return "redirect:/categorie";
	}
	
	
	@GetMapping("/cleantoast")
	public String cleanToast(Model model) {
		
		nomeCategoriaInserita = " ";
		
		inserimentoCorretto = false;
		
		gestioneCategorie(model);
		
		return "redirect:/categorie";
	}
	

}
