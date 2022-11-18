package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
