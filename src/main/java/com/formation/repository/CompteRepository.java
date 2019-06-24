package com.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.formation.model.Compte;

@EnableJpaRepositories
public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	public List<Compte> findByNom(String searchString);

	
}
