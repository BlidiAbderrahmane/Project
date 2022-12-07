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

import com.example.demo.entity.Famille;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Produit;
import com.example.demo.service.FamilleService;
import com.example.demo.service.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	@Autowired
	private ProduitService prodService;
	
	@PostMapping("/ajouter")
	public Produit AjouterProduit(@RequestBody Produit produit) {
		prodService.saveProduit(produit);
		return produit;
	}
	
	@PutMapping("/modifier/{id}")
	public ResponseEntity<?> ModifierProduit (@PathVariable Long id, @RequestBody Produit produit) {
		Produit produitExist= prodService.findProduitById(id);
		System.out.println(produitExist.getId_prd());
		produitExist.setLib_prd(produit.getLib_prd());
		produitExist.setDescription_prd(produit.getDescription_prd());
		produitExist.setPrix_prd(produit.getPrix_prd());
		produitExist.setDateAjout_prd(produit.getDateAjout_prd());
		produitExist.setPrix_livr(produit.getPrix_livr());
		Produit savedProduit=prodService.saveProduit(produitExist);
		return ResponseEntity.ok().body(savedProduit);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public String SupprimerProduit(@PathVariable Long id) {
		prodService.deleteProduitById(id);
		return "Suppression du Produit est effectuée";
	}
	
	@GetMapping("/consulter/{id}")
	public Produit ConsulterProduit(@PathVariable Long id) {
		return prodService.findProduitById(id);
	}
	
	@GetMapping("/liste")
	public List<Produit> ListeProduit() {
		return prodService.getAllProd();
	}
	
	@GetMapping("/listeFournisseur/{id}")
	public List<Produit> ListeFournisseur(@PathVariable Long id) {
		return prodService.getAllProdByFournisseur(id);
	}
	
	@GetMapping("/listeMarque/{id}")
	public List<Produit> ListeMarque(@PathVariable Long id) {
		return prodService.getAllProdByLabo(id);
	}
	
	@GetMapping("/listeCategorie/{id}")
	public List<Produit> ListeCategorie(@PathVariable Long id) {
		return prodService.getAllProdByFamille(id);
	}
}
