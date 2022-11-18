package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Fournisseur")
public class Fournisseur implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_fournisseur;
	
	@Column(name="nom_fournisseur")
	private String nom_fournisseur;
	
	@Column(name="adresse_fournisseur")
	private String adresse_fournisseur;
	
	@Column(name="email_fournisseur")
	private String email_fournisseur;
	
	@Column(name="tel_fournisseur")
	private int tel_fournisseur;
	
	@JsonIgnore
	@OneToMany(mappedBy="facture")
	private List<Facture> facture;

}
