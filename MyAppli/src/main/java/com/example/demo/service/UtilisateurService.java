package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Laboratoire;
import com.example.demo.entity.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository util;
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		return util.save(utilisateur);
	}
	
	public void deleteUtilisateurById(Long id) {
		Utilisateur utilisateur = util.getOne(id);
		util.delete(utilisateur);
	}
	
	public Utilisateur findUtilisateurById(Long id) {
		return util.findById(id).get();
	}
	
	public List<Utilisateur> getAllUtil() {
		return util.findAll();
	}
}
