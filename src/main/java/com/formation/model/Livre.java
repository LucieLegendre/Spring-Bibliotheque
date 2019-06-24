package com.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Livre")
public class Livre {

	private int isbn;
	private String titre;
	private String auteur;
	private float prix;
	private int stock;

	private Librairie librairie;

	public Livre(String titre, String auteur, float prix, int stock, Librairie librairie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
		this.stock = stock;
		this.librairie = librairie;
	}

	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ISBN")
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Column(name = "Titre")
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "Auteur")
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Column(name = "Prix")
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Column(name = "Stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_librairie")
	public Librairie getLibrairie() {
		return librairie;
	}

	public void setLibrairie(Librairie librairie) {
		this.librairie = librairie;
	}

	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", titre=" + titre + ", auteur=" + auteur + ", prix=" + prix + ", stock=" + stock
				+ ", librairie=" + librairie + "]";
	}



}
