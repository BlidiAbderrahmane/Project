package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="T_Facture")
public class Facture implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_fact_achat;
	
	@JsonFormat(pattern="dd-MM-YYYY")
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
	@JoinColumn(name="id_fournisseur", referencedColumnName="id")
	@OnDelete (action=OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
}
