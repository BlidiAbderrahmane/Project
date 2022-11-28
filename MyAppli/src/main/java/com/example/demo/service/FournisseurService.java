package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fournisseur;
import com.example.demo.repository.FournisseurRepository;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository four;
	
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		return four.save(fournisseur);
	}
	
	public void deleteFournisseurById(Long id) {
		Fournisseur fournisseur = four.getOne(id);
		four.delete(fournisseur);
	}
	
	public Fournisseur findFournisseurById(Long id) {
		return four.findById(id).get();
	}
}
