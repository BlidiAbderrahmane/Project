package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_Fournisseur")
public class Fournisseur implements Serializable {
	
	@Id
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
	@OneToMany(mappedBy="fournisseur")
	private List<Facture> facture;
	
	@JsonIgnore
	@OneToMany(mappedBy="fournisseur")
	private List<Commande_Prd> id_commande_produit;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_util", referencedColumnName="id_util")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Utilisateur utilisateur;

	public Fournisseur(Long id_fournisseur, String nom_fournisseur, String adresse_fournisseur,
			String email_fournisseur, int tel_fournisseur, List<Facture> facture,
			List<Commande_Prd> id_commande_produit, Utilisateur utilisateur) {
		super();
		this.id_fournisseur = id_fournisseur;
		this.nom_fournisseur = nom_fournisseur;
		this.adresse_fournisseur = adresse_fournisseur;
		this.email_fournisseur = email_fournisseur;
		this.tel_fournisseur = tel_fournisseur;
		this.facture = facture;
		this.id_commande_produit = id_commande_produit;
		this.utilisateur = utilisateur;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_fournisseur() {
		return id_fournisseur;
	}

	public void setId_fournisseur(Long id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}

	public String getNom_fournisseur() {
		return nom_fournisseur;
	}

	public void setNom_fournisseur(String nom_fournisseur) {
		this.nom_fournisseur = nom_fournisseur;
	}

	public String getAdresse_fournisseur() {
		return adresse_fournisseur;
	}

	public void setAdresse_fournisseur(String adresse_fournisseur) {
		this.adresse_fournisseur = adresse_fournisseur;
	}

	public String getEmail_fournisseur() {
		return email_fournisseur;
	}

	public void setEmail_fournisseur(String email_fournisseur) {
		this.email_fournisseur = email_fournisseur;
	}

	public int getTel_fournisseur() {
		return tel_fournisseur;
	}

	public void setTel_fournisseur(int tel_fournisseur) {
		this.tel_fournisseur = tel_fournisseur;
	}

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}

	public List<Commande_Prd> getId_commande_produit() {
		return id_commande_produit;
	}

	public void setId_commande_produit(List<Commande_Prd> id_commande_produit) {
		this.id_commande_produit = id_commande_produit;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
