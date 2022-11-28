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

import com.example.demo.entity.Laboratoire;
import com.example.demo.service.LaboratoireService;

@RestController
@RequestMapping("/laboratoires")
public class LaboratoireController {
	@Autowired
	private LaboratoireService laboService;
	
	@PostMapping("/Ajouter")
	public Laboratoire AjouterLaboratoire(@RequestBody Laboratoire laboratoire) {
		laboService.saveLaboratoire(laboratoire);
		return laboratoire;
	}
	
	@PutMapping("/Modifier/{id}")
	public ResponseEntity<?> ModifierLaboratoire (@PathVariable Long id, @RequestBody Laboratoire famille) {
		Laboratoire laboratoireExist= laboService.findLaboById(id);
		System.out.println(laboratoireExist.getId_labo());
		laboratoireExist.setLib_labo(famille.getLib_labo());
		Laboratoire savedLabo=laboService.saveLaboratoire(laboratoireExist);
		return ResponseEntity.ok().body(savedLabo);
	}
	
	@DeleteMapping("/Supprimer/{id}")
	public String SupprimerLaboratoire (@PathVariable Long id) {
		laboService.deleteLaboratoireById(id);
		return "Suppression du Laboratoire est effectuée";
	}
	
	@GetMapping("/Liste")
	public List<Laboratoire> ListeLaboratoire() {
		return laboService.getAllLabo();
	}
}
