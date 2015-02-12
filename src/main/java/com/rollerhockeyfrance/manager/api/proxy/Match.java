package com.rollerhockeyfrance.manager.api.proxy;

import java.util.Date;

public class Match {

	private Date date;
	private Integer matchId;
	private Integer journeeId;
	private String lieu;
	private String heure;
	private String equipeA;
	private Integer equipeAId;
	private Integer scoreA;
	private Boolean avecProlongation;
	private Integer scoreATab;
	private Integer scoreBTab;
	private Integer scoreB;
	private String equipeB;
	private Integer equipeBId;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public Integer getJourneeId() {
		return journeeId;
	}
	public void setJourneeId(Integer journeeId) {
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
	public Integer getEquipeAId() {
		return equipeAId;
	}
	public void setEquipeAId(Integer equipeAId) {
		this.equipeAId = equipeAId;
	}
	public Integer getScoreA() {
		return scoreA;
	}
	public void setScoreA(Integer scoreA) {
		this.scoreA = scoreA;
	}
	public Boolean getAvecProlongation() {
		return avecProlongation;
	}
	public void setAvecProlongation(Boolean avecProlongation) {
		this.avecProlongation = avecProlongation;
	}
	public Integer getScoreATab() {
		return scoreATab;
	}
	public void setScoreATab(Integer scoreATab) {
		this.scoreATab = scoreATab;
	}
	public Integer getScoreBTab() {
		return scoreBTab;
	}
	public void setScoreBTab(Integer scoreBTab) {
		this.scoreBTab = scoreBTab;
	}
	public Integer getScoreB() {
		return scoreB;
	}
	public void setScoreB(Integer scoreB) {
		this.scoreB = scoreB;
	}
	public String getEquipeB() {
		return equipeB;
	}
	public void setEquipeB(String equipeB) {
		this.equipeB = equipeB;
	}
	public Integer getEquipeBId() {
		return equipeBId;
	}
	public void setEquipeBId(Integer equipeBId) {
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
