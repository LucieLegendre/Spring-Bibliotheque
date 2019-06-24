package com.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.formation.model.Compte;
import com.formation.model.Reservation;

@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findById(int searchInt);
	
	List<Reservation> findByCompte(Compte cp);

}
