package com.formation.main;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.model.Compte;
import com.formation.model.Librairie;
import com.formation.model.Livre;
import com.formation.model.Panier;
import com.formation.service.CompteService;
import com.formation.service.LibrairieService;
import com.formation.service.LivreService;
import com.formation.service.PanierService;
import com.formation.service.ReservationService;


public class Main {

	public static void main(String[] args) {

		// Create Spring application contact
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		//Get service from context
		LivreService livreService = ctx.getBean(LivreService.class);
		CompteService compteService= ctx.getBean(CompteService.class);
		LibrairieService librairieService = ctx.getBean(LibrairieService.class);
		ReservationService reservationService = ctx.getBean(ReservationService.class);
		PanierService panierService =  ctx.getBean(PanierService.class);
			
		//Instanciation
		//Librairie
		Librairie lib1 = new Librairie("lib1", "Nantes");
		Librairie lib2 = new Librairie("lib2", "Brest");
		
		librairieService.add(lib1);
		librairieService.add(lib2);
		
		List<Librairie> listLib = librairieService.findAll();
//		System.out.println(listLib.toString()); affichage sur une ligne
		for(Librairie librairie : listLib) {
			System.out.println(librairie.toString());
		}
		
		//Livre
		Livre livre1 = new Livre("Titre1", "auteur1", (float) 5.60, 10, lib1);
		Livre livre2 = new Livre("Titre2", "auteur2", (float) 8.50, 25, lib1);
		Livre livre3 = new Livre("Titre3", "auteur3", (float) 1000, 5, lib2);
		Livre livre4 = new Livre("Titre4", "auteur4", (float) 12.30, 50, lib2);
		Livre livre5 = new Livre("Titre5", "auteur5", (float) 25.99, 0, lib1);
		Livre livre6 = new Livre("Titre6", "auteur6", (float) 9.99, 100, lib2);
		
		livreService.add(livre1);
		livreService.add(livre2);
		livreService.add(livre3);
		livreService.add(livre4);
		livreService.add(livre5);
		livreService.add(livre6);
		
		//Compte
		Compte compte1 = new Compte("nom1", "prenom1", "login1", "password1", (float) 600, 2, "Nantes", lib1);
		Compte compte2 = new Compte("nom2", "prenom2", "login2", "password2", (float) 800, 4, "Brest", lib2);
		
		compteService.add(compte1);
		compteService.add(compte2);
		
		//Reservation
//		reservationService.reserver(compte1, livre4);
//		reservationService.reserver(compte2, livre4);
//		reservationService.reserver(compte1, livre3);
//		reservationService.reserver(compte1, livre1);
				
		//Panier
		Panier panier1 = new Panier();
		List<Livre> list1 =  new ArrayList<>();
		list1.add(livre1);
		list1.add(livre2);
		list1.add(livre4);
		panier1.setLlivres(list1);
		panierService.doReservationListe(compte1, panier1);
		
		Panier panier2 = new Panier();
		List<Livre> list2 = new ArrayList<>();
		list2.add(livre2);
		list2.add(livre3);
		list2.add(livre5);
		list2.add(livre6);
		panier2.setLlivres(list2);
		panierService.doReservationListe(compte2, panier2);
		
		//Retour
		reservationService.retour(compte1, livre4);
		reservationService.retour(compte2, livre2);
		reservationService.retour(compte2, livre6);
						
		ctx.close();		
	}
}
