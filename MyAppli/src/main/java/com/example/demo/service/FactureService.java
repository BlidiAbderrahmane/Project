package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;

@Service
public class FactureService {
	@Autowired
	private FactureRepository fact;
	
	public Facture saveFactureAchat(Facture facture) {
		return fact.save(facture);
	}
	
	public Facture findFactureAchat(Long id) {
		return fact.findById(id).get();
	}
}
