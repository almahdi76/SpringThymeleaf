package com.AKA.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;



@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Produit> pageProduit=
				produitRepository.findAll();
		model.addAttribute("listProduit",pageProduit);
		
		return "produits";
	}
}
