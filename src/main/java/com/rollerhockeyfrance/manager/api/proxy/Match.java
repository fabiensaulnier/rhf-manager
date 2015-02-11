package com.rollerhockeyfrance.manager.api.proxy;

import java.util.Date;

public class Match {

	private Date date;
	private int matchId;
	private int journeeId;
	private String lieu;
	private String heure;
	private String equipeA;
	private int equipeAId;
	private int scoreA;
	private boolean avecProlongation;
	private int scoreATab;
	private int scoreBTab;
	private int scoreB;
	private String equipeB;
	private int equipeBId;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getJourneeId() {
		return journeeId;
	}
	
	public void setJourneeId(int journeeId) {
		this.journeeId = journeeId;
	}
	
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getHeure() {
		return heure;
	}
	
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	public String getEquipeA() {
		return equipeA;
	}
	
	public void setEquipeA(String equipeA) {
		this.equipeA = equipeA;
	}
	
	public int getEquipeAId() {
		return equipeAId;
	}
	
	public void setEquipeAId(int equipeAId) {
		this.equipeAId = equipeAId;
	}
	
	public int getScoreA() {
		return scoreA;
	}
	
	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}
	
	public boolean isAvecProlongation() {
		return avecProlongation;
	}
	
	public void setAvecProlongation(boolean avecProlongation) {
		this.avecProlongation = avecProlongation;
	}
	
	public int getScoreATab() {
		return scoreATab;
	}
	
	public void setScoreATab(int scoreATab) {
		this.scoreATab = scoreATab;
	}
	
	public int getScoreBTab() {
		return scoreBTab;
	}
	
	public void setScoreBTab(int scoreBTab) {
		this.scoreBTab = scoreBTab;
	}
	
	public int getScoreB() {
		return scoreB;
	}
	
	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}
	
	public String getEquipeB() {
		return equipeB;
	}
	
	public void setEquipeB(String equipeB) {
		this.equipeB = equipeB;
	}
	
	public int getEquipeBId() {
		return equipeBId;
	}
	
	public void setEquipeBId(int equipeBId) {
		this.equipeBId = equipeBId;
	}

	@Override
	public String toString() {
		return "Match [date=" + date + ", matchId=" + matchId + ", journeeId="
				+ journeeId + ", lieu=" + lieu + ", heure=" + heure
				+ ", equipeA=" + equipeA + ", equipeAId=" + equipeAId
				+ ", scoreA=" + scoreA + ", avecProlongation="
				+ avecProlongation + ", scoreATab=" + scoreATab
				+ ", scoreBTab=" + scoreBTab + ", scoreB=" + scoreB
				+ ", equipeB=" + equipeB + ", equipeBId=" + equipeBId + "]";
	}
	
}
