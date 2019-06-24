package com.formation.model;

import java.util.List;

public class Panier {

	private int id;
	private List<Livre> llivres;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(List<Livre> llivres) {
		super();
		this.llivres = llivres;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Livre> getLlivres() {
		return llivres;
	}


	public void setLlivres(List<Livre> llivres) {
		this.llivres = llivres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [id=" + id + ", llivres=" + llivres + "]";
	}	
	
	
}
