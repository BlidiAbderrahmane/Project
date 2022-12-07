package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Famille;
import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository prod;
	
	public Produit saveProduit(Produit produit) {
		return prod.save(produit);
	}
	
	public Produit findProduitById(Long id) {
		return prod.findById(id).get();
	}
	
	public void deleteProduitById(Long id) {
		Produit produit = prod.getOne(id);
		prod.delete(produit);
	}
	
	public List<Produit> getAllProd() {
		return prod.findAll();
	}
	
	public List<Produit> getAllProdByFamille(Long id) {
		return prod.FindProdByFamille(id);
	}
	
	public List<Produit> getAllProdByFournisseur(Long id) {
		return prod.FindProdByFournisseur(id);
	}
	
	public List<Produit> getAllProdByLabo(Long id) {
		return prod.FindProdByLabo(id);
	}
	
}
