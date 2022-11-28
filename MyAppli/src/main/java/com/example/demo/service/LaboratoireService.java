package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Laboratoire;
import com.example.demo.repository.LaboratoireRepository;

@Service
public class LaboratoireService {
	@Autowired
	private LaboratoireRepository labo;
	
	public Laboratoire saveLaboratoire(Laboratoire laboratoire) {
		return labo.save(laboratoire);
	}
	
	public void deleteLaboratoireById(Long id) {
		Laboratoire laboratoire = labo.getOne(id);
		labo.delete(laboratoire);
	}
	
	public List<Laboratoire> getAllLabo() {
		return labo.findAll();
	}
	
	public Laboratoire findLaboById(Long id) {
		return labo.findById(id).get();
	}
}
