package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Commande_Prd;
import com.example.demo.entity.Famille;
import com.example.demo.entity.Produit;
import com.example.demo.service.Commande_PrdService;

@RestController
@RequestMapping("/commandes")
public class Commande_PrdController {
	@Autowired
	private Commande_PrdService cprdService;
	
	@PostMapping("/ajouter")
	public Commande_Prd AjouterCommande_Prd(@RequestBody Commande_Prd commande_prd) {
		cprdService.saveCommande_Prd(commande_prd);
		return commande_prd;
	}
	
	@PutMapping("/modifier/{id}")
	public ResponseEntity<?> ModifierCommande_Prd (@PathVariable Long id, @RequestBody Commande_Prd commande_prd) {
		Commande_Prd commande_prdExist= cprdService.findCommande_PrdById(id);
		System.out.println(commande_prdExist.getId());
		commande_prdExist.setDateFourni(commande_prd.getDateFourni());
		commande_prdExist.setQuantiteFourni(commande_prd.getQuantiteFourni());
		Commande_Prd savedCprd=cprdService.saveCommande_Prd(commande_prdExist);
		return ResponseEntity.ok().body(savedCprd);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public String SupprimerCommande_Prd(@PathVariable Long id) {
		cprdService.deleteCommande_PrdById(id);
		return "Suppression du Commande est effectuée";
	}
	
	@GetMapping("/liste")
	public List<Commande_Prd> ListeCommande_Prd() {
		return cprdService.getAllCommande_Prd();
	}
	
	@GetMapping("/consulter/{id}")
	public Commande_Prd ConsulterCommande_Prd(@PathVariable Long id) {
		return cprdService.findCommande_PrdById(id);
	}
}
