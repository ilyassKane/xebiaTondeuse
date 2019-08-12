package com.xebia.xebia_tondeuse;

public class Pelouse {

	private Integer longeur;

	private Integer largeur;

	public Pelouse(Integer longeur, Integer largeur) {
		this.longeur = longeur;
		this.largeur = largeur;
	}

	public Integer getLongeur() {
		return longeur;
	}

	public void setLongeur(Integer longeur) {
		this.longeur = longeur;
	}

	public Integer getLargeur() {
		return largeur;
	}

	public void setLargeur(Integer largeur) {
		this.largeur = largeur;
	}
}
