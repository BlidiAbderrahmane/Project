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
@Table(name="T_Laboratoire")
public class Laboratoire implements  Serializable {
	@Id
	private Long id_labo;

	@Column(name="libelle")
	private String lib_labo;
	
	@JsonIgnore
	@OneToMany(mappedBy="laboratoire")
	private List<Produit> produits;

	public Laboratoire(Long id_labo, String lib_labo, List<Produit> produits) {
		super();
		this.id_labo = id_labo;
		this.lib_labo = lib_labo;
		this.produits = produits;
	}

	public Laboratoire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_labo() {
		return id_labo;
	}

	public void setId_labo(Long id_labo) {
		this.id_labo = id_labo;
	}

	public String getLib_labo() {
		return lib_labo;
	}

	public void setLib_labo(String lib_labo) {
		this.lib_labo = lib_labo;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}