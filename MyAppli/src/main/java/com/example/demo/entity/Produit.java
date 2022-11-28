package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_Produit")
public class Produit implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prd;
	
	@Column(name="lib_prd")
	private String lib_prd;
	
	@Column(name="description_prd")
	private String description_prd;
	
	@Column(name="prix_prd")
	private Double prix_prd;
	
	@Column(name="dateAjout_prd")
	private Date dateAjout_prd;
	
	@Column(name="prix_livr")
	private Float prix_livr;
	
	@ManyToMany
	@JoinTable(
			name="Facture_Produit",
			joinColumns= @JoinColumn(name="id_fact_achat"),
			inverseJoinColumns= @JoinColumn(name="id_prod"))
	List<Facture> factures;
	
	@ManyToMany
	@JoinTable(
			name="Utilisateur_Produit",
			joinColumns= @JoinColumn(name="id_util"),
			inverseJoinColumns= @JoinColumn(name="id_prod"))
	List<Utilisateur> utilisateurs;
	
	@JsonIgnore
	@OneToMany(mappedBy="produit")
	private List<Commande_Prd> id_commande_produit;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_labo", referencedColumnName="id_labo")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Laboratoire laboratoire;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_famille", referencedColumnName="id_famille")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Famille famille;

	public Produit(Long id_prd, String lib_prd, String description_prd, Double prix_prd, Date dateAjout_prd,
			Float prix_livr, List<Facture> factures, List<Utilisateur> utilisateurs,
			List<Commande_Prd> id_commande_produit, Laboratoire laboratoire, Famille famille) {
		super();
		this.id_prd = id_prd;
		this.lib_prd = lib_prd;
		this.description_prd = description_prd;
		this.prix_prd = prix_prd;
		this.dateAjout_prd = dateAjout_prd;
		this.prix_livr = prix_livr;
		this.factures = factures;
		this.utilisateurs = utilisateurs;
		this.id_commande_produit = id_commande_produit;
		this.laboratoire = laboratoire;
		this.famille = famille;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_prd() {
		return id_prd;
	}

	public void setId_prd(Long id_prd) {
		this.id_prd = id_prd;
	}

	public String getLib_prd() {
		return lib_prd;
	}

	public void setLib_prd(String lib_prd) {
		this.lib_prd = lib_prd;
	}

	public String getDescription_prd() {
		return description_prd;
	}

	public void setDescription_prd(String description_prd) {
		this.description_prd = description_prd;
	}

	public Double getPrix_prd() {
		return prix_prd;
	}

	public void setPrix_prd(Double prix_prd) {
		this.prix_prd = prix_prd;
	}

	public Date getDateAjout_prd() {
		return dateAjout_prd;
	}

	public void setDateAjout_prd(Date dateAjout_prd) {
		this.dateAjout_prd = dateAjout_prd;
	}

	public Float getPrix_livr() {
		return prix_livr;
	}

	public void setPrix_livr(Float prix_livr) {
		this.prix_livr = prix_livr;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Commande_Prd> getId_commande_produit() {
		return id_commande_produit;
	}

	public void setId_commande_produit(List<Commande_Prd> id_commande_produit) {
		this.id_commande_produit = id_commande_produit;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	
}
