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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_CommandePrd")
public class Commande_Prd implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_prd", referencedColumnName="id")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Produit produit;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_fournisseur", referencedColumnName="id")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
	
	@Column(name="quantiteFourni")
	private int quantiteFourni;
	
	@Column(name="dateFourni")
	private Date dateFourni;
}
