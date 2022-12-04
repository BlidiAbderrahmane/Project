package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commande_Prd;
import com.example.demo.repository.Commande_PrdRepository;

@Service
public class Commande_PrdService {
	@Autowired
	private Commande_PrdRepository cprd;
	
	public Commande_Prd saveCommande_Prd(Commande_Prd commande_prd) {
		return cprd.save(commande_prd);
	}
	
	public void deleteCommande_PrdById(Long id) {
		Commande_Prd commande_prd = cprd.getOne(id);
		cprd.delete(commande_prd);
	}
	
	public List<Commande_Prd> getAllCommande_Prd() {
		return cprd.findAll();
	}
	
	public Commande_Prd findCommande_PrdById(Long id) {
		return cprd.findById(id).get();
	}
}
