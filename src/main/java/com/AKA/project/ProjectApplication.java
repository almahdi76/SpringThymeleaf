package com.AKA.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext cxt=SpringApplication.run(ProjectApplication.class, args);
		ProduitRepository produitRepository=cxt.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("Xiaomi S9",250,15));
		produitRepository.save(new Produit("Samsung S12",1500,30));
		produitRepository.save(new Produit("OPPO 12",450,11));
		produitRepository.save(new Produit("Nokia 1112",110,14));
		produitRepository.findAll().forEach(p -> System.out.println(p.getDesignation()));
		
		
		
		
		
		
		
	}

}
