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
@Table(name="tb_Compte")
public class Compte {

	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private float solde;
	private int type;
	private String adresse;
	
	private Librairie librairie;

	public Compte(String nom, String prenom, String login, String password, float solde, int type, String adresse,
			Librairie librairie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.solde = solde;
		this.type = type;
		this.adresse = adresse;
		this.librairie = librairie;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="Nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="Prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name="Login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="Solde")
	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Column(name="Type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="Adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "id_librairie")
	public Librairie getLibrairie() {
		return librairie;
	}

	public void setLibrairie(Librairie librairie) {
		this.librairie = librairie;
	}


	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", solde=" + solde + ", type=" + type + ", adresse=" + adresse + ", librairie=" + librairie
				+ "]";
	}



}
