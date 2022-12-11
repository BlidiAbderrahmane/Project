package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Famille;
import com.example.demo.service.FamilleService;

@CrossOrigin
@RestController
@RequestMapping("/familles")
public class FamilleController {
	@Autowired
	private FamilleService famService;
	
	@PostMapping("/ajouter")
	public Famille AjouterFamille(@RequestBody Famille famille) {
		famService.saveFamille(famille);
		return famille;
	}
	
	@PutMapping("/modifier/{id}")
	public ResponseEntity<?> ModifierFamille (@PathVariable Long id, @RequestBody Famille famille) {
		Famille familleExist= famService.findFamById(id);
		System.out.println(familleExist.getId_famille());
		familleExist.setLib_famille(famille.getLib_famille());
		Famille savedFam=famService.saveFamille(familleExist);
		return ResponseEntity.ok().body(savedFam);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public String SupprimerFamille(@PathVariable Long id) {
		famService.deleteFamilleById(id);
		return "Suppression du Famille est effectuée";
	}
	
	@GetMapping("/liste")
	public List<Famille> ListeFamille() {
		return famService.getAllFam();
	}
}
