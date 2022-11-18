package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
			joinColumns= @JoinColumn(name="Id_Facture"),
			inverseJoinColumns= @JoinColumn(name="Id_Produit"))
	List<Facture> facture;
	
	@JsonIgnore
	@OneToMany(mappedBy="produit")
	private List<Commande_Prd> id_commande_produit;
}
