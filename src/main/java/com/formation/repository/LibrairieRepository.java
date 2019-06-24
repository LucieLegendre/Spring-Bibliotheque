package com.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.formation.model.Librairie;

@EnableJpaRepositories
public interface LibrairieRepository extends JpaRepository<Librairie, Long> {

	public List<Librairie> findByNom(String searchString);
}
