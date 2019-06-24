package com.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.formation.model.Compte;

@Entity
@Table(name = "tb_Reservations")
public class Reservation {

	private int id;
	private Date date;
	private float prix;
	private String etat;
	private Date dateRendu;

	private Compte compte;
	private Livre livre;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int id, Date date, float prix, String etat, Date dateRendu) {
		super();
		this.id = id;
		this.date = date;
		this.prix = prix;
		this.etat = etat;
		this.dateRendu = dateRendu;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Prix")
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Column(name = "Etat")
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Column(name = "Date_Rendu")
	public Date getDateRendu() {
		return dateRendu;
	}

	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Compte")
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Livre")
	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", prix=" + prix + ", etat=" + etat + ", dateRendu="
				+ dateRendu + "]";
	}

}
