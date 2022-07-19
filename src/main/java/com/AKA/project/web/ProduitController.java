package com.AKA.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;



@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	
//	@RequestMapping(value="/index")
//	public String index(Model model) {
//		Pageable pageable = PageRequest.of(0, 4);
//        Page<Produit> pageProducts = produitRepository.findAll(pageable);
//		model.addAttribute("listProduit",pageProducts);
//		return "produits";
//	}
	
	@RequestMapping(value="/index")
	public String index(Model model,@RequestParam(name="page", defaultValue="0") int p,@RequestParam(name="size",defaultValue="3") int s) {
		Pageable pageable = PageRequest.of(p, s);
        Page<Produit> pageProducts = produitRepository.findAll(pageable);
		model.addAttribute("listProduit",pageProducts);
		int pages[]=new int[pageProducts.getTotalPages()];
		model.addAttribute("pages", pages);
		return "produits";
	}
}
