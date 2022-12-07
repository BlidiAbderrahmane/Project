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
	
	@Column(name="mot_de_passe")
	private String mdp_util;
	
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

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Long id_util, String nom_util, String prenom_util, String adresse_util, String email_util,
			String mdp_util, int codePostal_util, Date dateNaissance_util, List<Fournisseur> fournisseur,
			List<Produit> produits) {
		super();
		this.id_util = id_util;
		this.nom_util = nom_util;
		this.prenom_util = prenom_util;
		this.adresse_util = adresse_util;
		this.email_util = email_util;
		this.mdp_util = mdp_util;
		this.codePostal_util = codePostal_util;
		this.dateNaissance_util = dateNaissance_util;
		this.fournisseur = fournisseur;
		this.produits = produits;
	}

	public Long getId_util() {
		return id_util;
	}

	public void setId_util(Long id_util) {
		this.id_util = id_util;
	}

	public String getNom_util() {
		return nom_util;
	}

	public void setNom_util(String nom_util) {
		this.nom_util = nom_util;
	}

	public String getPrenom_util() {
		return prenom_util;
	}

	public void setPrenom_util(String prenom_util) {
		this.prenom_util = prenom_util;
	}

	public String getAdresse_util() {
		return adresse_util;
	}

	public void setAdresse_util(String adresse_util) {
		this.adresse_util = adresse_util;
	}

	public String getEmail_util() {
		return email_util;
	}

	public void setEmail_util(String email_util) {
		this.email_util = email_util;
	}

	

	public String getMdp_util() {
		return mdp_util;
	}

	public void setMdp_util(String mdp_util) {
		this.mdp_util = mdp_util;
	}

	public int getCodePostal_util() {
		return codePostal_util;
	}

	public void setCodePostal_util(int codePostal_util) {
		this.codePostal_util = codePostal_util;
	}

	public Date getDateNaissance_util() {
		return dateNaissance_util;
	}

	public void setDateNaissance_util(Date dateNaissance_util) {
		this.dateNaissance_util = dateNaissance_util;
	}

	public List<Fournisseur> getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(List<Fournisseur> fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
