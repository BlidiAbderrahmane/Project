package com.example.demo.controller;

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

import com.example.demo.entity.Fournisseur;
import com.example.demo.service.FournisseurService;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {
	@Autowired
	private FournisseurService fourService;
	
	@PostMapping("/ajouter")
	public Fournisseur AjouterFournisseur(@RequestBody Fournisseur fournisseur) {
		fourService.saveFournisseur(fournisseur);
		return fournisseur;
	}
	
	@PutMapping("/modifier/{id}")
	public ResponseEntity<?> ModifierFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
		Fournisseur fournisseurExist = fourService.findFournisseurById(id);
		System.out.println(fournisseurExist.getId_fournisseur());
		fournisseurExist.setNom_fournisseur(fournisseur.getNom_fournisseur());
		fournisseurExist.setAdresse_fournisseur(fournisseur.getAdresse_fournisseur());
		fournisseurExist.setEmail_fournisseur(fournisseur.getEmail_fournisseur());
		fournisseurExist.setTel_fournisseur(fournisseur.getTel_fournisseur());
		Fournisseur savedFournisseur = fourService.saveFournisseur(fournisseurExist);
		return ResponseEntity.ok().body(savedFournisseur);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public String SupprimerFournisseur(@PathVariable Long id) {
		fourService.deleteFournisseurById(id);
		return "Suppression du Fournisseur est effectuée";
	}
	
	@GetMapping("/consulter/{id}")
	public Fournisseur ConsulterFournisseur(@PathVariable Long id) {
		return fourService.findFournisseurById(id);
	}
}
