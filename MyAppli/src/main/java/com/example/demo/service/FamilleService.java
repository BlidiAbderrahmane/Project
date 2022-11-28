package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Famille;
import com.example.demo.repository.FamilleRepository;

@Service
public class FamilleService {
	@Autowired
	private FamilleRepository fam;
	
	public Famille saveFamille(Famille famille) {
		return fam.save(famille);
	}
	
	public void deleteFamilleById(Long id) {
		Famille famille = fam.getOne(id);
		fam.delete(famille);
	}
	
	public List<Famille> getAllFam() {
		return fam.findAll();
	}
	
	public Famille findFamById(Long id) {
		return fam.findById(id).get();
	}
}
