package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_CommandePrd")
public class Commande_Prd implements Serializable {
	@Id
	private Long id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_prd", referencedColumnName="id_prd")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Produit produit;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_fournisseur", referencedColumnName="id_fournisseur")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
	
	@Column(name="quantiteFourni")
	private int quantiteFourni;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="dateFourni")
	private Date dateFourni;
	
	
	
	public Commande_Prd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande_Prd(Long id, Produit produit, Fournisseur fournisseur, int quantiteFourni, Date dateFourni) {
		super();
		this.id = id;
		this.produit = produit;
		this.fournisseur = fournisseur;
		this.quantiteFourni = quantiteFourni;
		this.dateFourni = dateFourni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getQuantiteFourni() {
		return quantiteFourni;
	}

	public void setQuantiteFourni(int quantiteFourni) {
		this.quantiteFourni = quantiteFourni;
	}

	public Date getDateFourni() {
		return dateFourni;
	}

	public void setDateFourni(Date dateFourni) {
		this.dateFourni = dateFourni;
	}
}
