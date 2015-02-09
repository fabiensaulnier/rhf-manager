package com.rollerhockeyfrance.manager.api.proxy;

public class Classement {
	
	private int equipeId;
	private int position;
	private String nom;
	private int point;
	private int match;
	private int victoire;
	private int victoireProlongation;
	private int victoireTab;
	private int perdu;
	private int perduProlongation;
	private int perduTab;
	private int forfait;
	private int plus;
	private int moins;
	private int diff;
	
	public int getEquipeId() {
		return equipeId;
	}
	
	public void setEquipeId(int equipeId) {
		this.equipeId = equipeId;
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
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getMatch() {
		return match;
	}
	
	public void setMatch(int match) {
		this.match = match;
	}
	
	public int getVictoire() {
		return victoire;
	}
	
	public void setVictoire(int victoire) {
		this.victoire = victoire;
	}
	
	public int getVictoireProlongation() {
		return victoireProlongation;
	}
	
	public void setVictoireProlongation(int victoireProlongation) {
		this.victoireProlongation = victoireProlongation;
	}
	
	public int getVictoireTab() {
		return victoireTab;
	}
	
	public void setVictoireTab(int victoireTab) {
		this.victoireTab = victoireTab;
	}
	
	public int getPerdu() {
		return perdu;
	}
	
	public void setPerdu(int perdu) {
		this.perdu = perdu;
	}
	
	public int getPerduProlongation() {
		return perduProlongation;
	}
	
	public void setPerduProlongation(int perduProlongation) {
		this.perduProlongation = perduProlongation;
	}
	
	public int getPerduTab() {
		return perduTab;
	}
	
	public void setPerduTab(int perduTab) {
		this.perduTab = perduTab;
	}
	
	public int getForfait() {
		return forfait;
	}
	
	public void setForfait(int forfait) {
		this.forfait = forfait;
	}
	
	public int getPlus() {
		return plus;
	}
	
	public void setPlus(int plus) {
		this.plus = plus;
	}
	
	public int getMoins() {
		return moins;
	}
	
	public void setMoins(int moins) {
		this.moins = moins;
	}
	
	public int getDiff() {
		return diff;
	}
	
	public void setDiff(int diff) {
		this.diff = diff;
	}

	@Override
	public String toString() {
		return "Classement [equipeId=" + equipeId + ", position=" + position
				+ ", nom=" + nom + ", point=" + point + ", match=" + match
				+ ", victoire=" + victoire + ", victoireProlongation="
				+ victoireProlongation + ", victoireTab=" + victoireTab
				+ ", perdu=" + perdu + ", perduProlongation="
				+ perduProlongation + ", perduTab=" + perduTab + ", forfait="
				+ forfait + ", plus=" + plus + ", moins=" + moins + ", diff="
				+ diff + "]";
	}

}
