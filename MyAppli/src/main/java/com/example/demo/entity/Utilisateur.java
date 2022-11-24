package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Utilisateur")
public class Utilisateur implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_util;

	@Column(name="nom")
	private String nom_util;

	@Column(name="prenom")
	private String prenom_util;
	
	@Column(name="adresse")
	private String adresse_util;
	
	@Column(name="email")
	private String email_util;
	
	@Column(name="codePostal")
	private int codePostal_util;
	
	@JsonFormat(pattern="dd-MM-YYYY")
	@Column(name="dateNaissance")
	private Date dateNaissance_util;
	
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Fournisseur> fournisseur;
	
	@ManyToMany(mappedBy="utilisateurs")
	List<Produit> produits;
}
