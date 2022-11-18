package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Laboratoire")
public class Laboratoire implements  Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_labo;

	@Column(name="libelle")
	private String lib_labo;
}