package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_Facture")
public class Facture implements Serializable {
	
	@Id
	private Long id_fact_achat;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="date")
	private Date date;
	
	@Column(name="total_ht")
	private double total_ht;
	
	@Column(name="total_tva")
	private double total_tva;
	
	@Column(name="total_ttc")
	private double total_ttc;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_fournisseur", referencedColumnName="id_fournisseur")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="factures")
	List<Produit> produits;
	

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(Long id_fact_achat, Date date, double total_ht, double total_tva, double total_ttc,
			Fournisseur fournisseur, List<Produit> produits) {
		super();
		this.id_fact_achat = id_fact_achat;
		this.date = date;
		this.total_ht = total_ht;
		this.total_tva = total_tva;
		this.total_ttc = total_ttc;
		this.fournisseur = fournisseur;
		this.produits = produits;
	}

	public Long getId_fact_achat() {
		return id_fact_achat;
	}

	public void setId_fact_achat(Long id_fact_achat) {
		this.id_fact_achat = id_fact_achat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal_ht() {
		return total_ht;
	}

	public void setTotal_ht(double total_ht) {
		this.total_ht = total_ht;
	}

	public double getTotal_tva() {
		return total_tva;
	}

	public void setTotal_tva(double total_tva) {
		this.total_tva = total_tva;
	}

	public double getTotal_ttc() {
		return total_ttc;
	}

	public void setTotal_ttc(double total_ttc) {
		this.total_ttc = total_ttc;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}
