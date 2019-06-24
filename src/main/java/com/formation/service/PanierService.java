package com.formation.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Compte;
import com.formation.model.Livre;
import com.formation.model.Panier;
import com.formation.model.Reservation;
import com.formation.repository.CompteRepository;
import com.formation.repository.LivreRepository;
import com.formation.repository.ReservationRepository;

@Component
public class PanierService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private LivreRepository livreRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Transactional
	public void doReservationListe(Compte c, Panier p) {
		for (Livre livre : p.getLlivres()) {
			
			Reservation r = new Reservation();
			if (livre.getStock() > 0 && c.getSolde() > livre.getPrix()) {
			Date date = new Date();
			r.setCompte(c);
			r.setLivre(livre);
			r.setDate(date);
			r.setEtat("non-rendu");
			r.setDateRendu(null);
			r.setPrix(livre.getPrix() * 1.2f);
			livre.setStock(livre.getStock() - 1);
			c.setSolde(c.getSolde() - livre.getPrix());
			livreRepository.save(livre);
			compteRepository.save(c);
			reservationRepository.save(r);
			
			}else if (livre.getStock() <= 0) {
				System.err.println("Le livre n'est pas disponible : titre : "+ livre.getTitre() +", stock : "+ livre.getStock());

			} else if (c.getSolde() < livre.getPrix()) {
				System.err.println("Le solde est insuffisant : id Compte : " + c.getId() +", solde : "+ c.getSolde() +" < "+ livre.getPrix());
			}
			
			System.out.println("*****************************");
			for (Livre l : p.getLlivres()) {				
				System.out.println(l.toString());			
			}
			System.out.println("*****************************");
		}
	}
}
