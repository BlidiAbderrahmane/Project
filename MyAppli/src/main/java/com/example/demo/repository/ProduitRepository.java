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
	
	@Query(value="select DISTINCT(tp.id_prd), tp.lib_prd, tp.description_prd, tp.prix_prd, tp.date_ajout_prd, tp.prix_livr, tp.id_famille, tp.id_labo from t_produit tp, t_commande_prd tcp where tcp.id_fournisseur= :idFournisseur and tp.id_prd=tcp.id_prd",nativeQuery=true)
	public List<Produit> FindProdByFournisseur(@Param(value="idFournisseur") Long id);
}
