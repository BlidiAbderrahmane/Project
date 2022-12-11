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
@Table(name="T_Famille")
public class Famille implements  Serializable {
	@Id
	private Long id_famille;

	@Column(name="libelle")
	private String lib_famille;
	
	@JsonIgnore
	@OneToMany(mappedBy="famille")
	private List<Produit> produits;

	public Famille(Long id_famille, String lib_famille, List<Produit> produits) {
		super();
		this.id_famille = id_famille;
		this.lib_famille = lib_famille;
		this.produits = produits;
	}

	public Famille() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_famille() {
		return id_famille;
	}

	public void setId_famille(Long id_famille) {
		this.id_famille = id_famille;
	}

	public String getLib_famille() {
		return lib_famille;
	}

	public void setLib_famille(String lib_famille) {
		this.lib_famille = lib_famille;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}