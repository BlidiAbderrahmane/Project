package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Produit;

public interface ProduitRepository extends JpaRepository <Produit,Long> {
	@Query(value="select * from t_produit where id_famille=:idFamille",nativeQuery=true)
	public List<Produit> FindProdByFamille(@Param(value="idFamille") Long id);
	
	@Query(value="select * from t_produit where id_labo=:idLabo",nativeQuery=true)
	public List<Produit> FindProdByLabo(@Param(value="idLabo") Long id);
	
	@Query(value="select * from t_produit where lib_prd like '%:keyword%'",nativeQuery=true)
	public List<Produit> FindProdByLib(@Param(value="keyword") String keyword);
}
