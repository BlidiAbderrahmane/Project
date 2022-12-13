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

import com.example.demo.entity.Laboratoire;
import com.example.demo.entity.Utilisateur;
import com.example.demo.service.UtilisateurService;


@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilService;
	
	@PostMapping("/ajouter")
	public Utilisateur AjouterUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilService.saveUtilisateur(utilisateur);
		return utilisateur;
	}
	
	@PutMapping("/modifier/{id}")
	public ResponseEntity<?> ModifierUtilisateur (@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurExist= utilService.findUtilisateurById(id);
		System.out.println(utilisateurExist.getId_util());
		utilisateurExist.setNom_util(utilisateur.getNom_util());
		utilisateurExist.setPrenom_util(utilisateur.getPrenom_util());
		utilisateurExist.setAdresse_util(utilisateur.getAdresse_util());
		utilisateurExist.setEmail_util(utilisateur.getEmail_util());
		utilisateurExist.setMdp_util(utilisateur.getMdp_util());
		utilisateurExist.setCodePostal_util(utilisateur.getCodePostal_util());
		utilisateurExist.setDateNaissance_util(utilisateur.getDateNaissance_util());
		Utilisateur savedUtil=utilService.saveUtilisateur(utilisateurExist);
		return ResponseEntity.ok().body(savedUtil);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void SupprimerUtilisateur (@PathVariable Long id) {
		utilService.deleteUtilisateurById(id);
	}
	
	@GetMapping("/liste")
	public List<Utilisateur> ListeUtilisateurs() {
		return utilService.getAllUtil();
	}
}
