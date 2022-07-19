package com.AKA.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;



@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
//	@RequestMapping(value="/index")
//	public String index() {
//		return "produits";
//	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Produit> produits=produitRepository.findAll();
		model.addAttribute("listProduit",produits);
		
		return "produits";
	}
}
