package com.rollerhockeyfrance.manager.api;

import java.util.List;

public class Competition {
	
	private List<Classement> classement;
	private List<Statistique> statistiques;
	private List<Match> matchs;
	
	public List<Classement> getClassement() {
		return classement;
	}
	
	public void setClassement(List<Classement> classement) {
		this.classement = classement;
	}
	
	public List<Statistique> getStatistiques() {
		return statistiques;
	}
	
	public void setStatistiques(List<Statistique> statistiques) {
		this.statistiques = statistiques;
	}
	
	public List<Match> getMatchs() {
		return matchs;
	}
	
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	
}
