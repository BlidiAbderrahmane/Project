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
}
