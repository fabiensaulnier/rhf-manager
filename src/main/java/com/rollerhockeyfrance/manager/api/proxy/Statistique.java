package com.rollerhockeyfrance.manager.api.proxy;

public class Statistique {
	
	private int joueurId;
	private int position;
	private String nom; 
	private String equipe;
	private int equipeId;
	private int but;
	
	public int getJoueurId() {
		return joueurId;
	}
	
	public void setJoueurId(int joueurId) {
		this.joueurId = joueurId;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getEquipe() {
		return equipe;
	}
	
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	public int getEquipeId() {
		return equipeId;
	}
	
	public void setEquipeId(int equipeId) {
		this.equipeId = equipeId;
	}
	
	public int getBut() {
		return but;
	}
	
	public void setBut(int but) {
		this.but = but;
	}

	@Override
	public String toString() {
		return "Statistique [joueurId=" + joueurId + ", position=" + position
				+ ", nom=" + nom + ", equipe=" + equipe + ", equipeId="
				+ equipeId + ", but=" + but + "]";
	}
	
}
