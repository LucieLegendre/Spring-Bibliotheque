package com.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.formation.model.Livre;

@EnableJpaRepositories
public interface LivreRepository extends JpaRepository<Livre, Long> {
	
	public List<Livre> findByAuteur(String searchString);

	public List<Livre> findByTitre(String titre);
	
//	@Query("select l from Livre where l.titre =:titre")
//	public List<Livre> findByTitreIs(@Param("titre") String titre);
}
