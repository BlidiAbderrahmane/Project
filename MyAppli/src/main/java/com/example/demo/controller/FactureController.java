package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Facture;
import com.example.demo.service.FactureService;

@CrossOrigin
@RestController
@RequestMapping("/factures")
public class FactureController {
	@Autowired
	private FactureService factService;
	
	@PostMapping("/ajouter")
	public Facture AjouterFacture(@RequestBody Facture fact) {
		factService.saveFactureAchat(fact);
		return fact;
	}
	
}
