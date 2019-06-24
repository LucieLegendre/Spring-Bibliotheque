package com.formation.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Compte;
import com.formation.model.Livre;
import com.formation.model.Reservation;

import com.formation.repository.LivreRepository;
import com.formation.repository.ReservationRepository;

@Component
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private LivreRepository livreRepository;

	@Transactional
	public void add(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Transactional
	public void update(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Transactional
	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	@Transactional(readOnly = true)
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Reservation> reservations) {
		for (Reservation reservation : reservations)
			reservationRepository.save(reservation);
	}

	@Transactional
	public List<Reservation> findById(int id) {
		return reservationRepository.findById(id);
	}

//	@Transactional
//	public void reserver(Compte c, Livre l) {
//		Reservation r = new Reservation();
//		Date date = new Date();
//		reservationRepository.save(r);
//		if (l.getStock() > 0 && c.getSolde() > l.getPrix()) {
//			r.setCompte(c);
//			r.setLivre(l);
//			r.setDate(date);
//			r.setPrix(l.getPrix() * 1.2f);
//			r.setEtat("non-rendu");
//			r.setDateRendu(null);
//			l.setStock(l.getStock() - 1);
//			c.setSolde(c.getSolde() - l.getPrix());
//			livreRepository.save(l);
//			compteRepository.save(c);
//			reservationRepository.save(r);
//		} else {
//			System.out.println("Le livre n'est pas disponible ou le solde est insuffisant");
//		}
//	}

	@Transactional
	public void retour(Compte c, Livre l) {
		List<Reservation> resa = reservationRepository.findByCompte(c);
		for (Reservation reservation : resa) {
			if (reservation.getLivre().getIsbn() == l.getIsbn()) {
				Date dateRendu = new Date();
				reservation.setEtat("rendu");
				reservation.setDateRendu(dateRendu);
				l.setStock(l.getStock() + 1);
				livreRepository.save(l);
				reservationRepository.save(resa);
				System.out.println("****************************");
				System.out.println("Le livre à bien été rendu");
				System.out.println("****************************");
			} 
		}
	}
}
