
  package com.univlittoral.projetback.repository;
  
  import java.util.ArrayList;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univlittoral.projetback.dto.TypeEnum;
import com.univlittoral.projetback.entity.LivreEntity;

  
 
@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Integer>{
	
	//Récupère une liste de livres ayant comme type {param}
	@Query(value="SELECT l FROM LivresEntity l where l.genre = :genre")
	List<LivreEntity> findLivresByGenre(@Param("genre") final TypeEnum genre);
	
	//Récupère la liste de livres triée dans l'ordre alphabétique
	@Query(value="SELECT * FROM livres order by nom ASC", nativeQuery=true)
	public List<LivreEntity> findAllLivresRepo();
	
	@Query("SELECT genre as labels FROM LivresEntity l GROUP BY l.genre")
	ArrayList<String> findGenre();

	@Query("SELECT count(genre) as values FROM LivresEntity l GROUP BY l.genre")
	ArrayList<Integer> findGenreNb();
	
}
 