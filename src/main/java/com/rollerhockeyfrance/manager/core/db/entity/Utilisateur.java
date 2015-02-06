package com.rollerhockeyfrance.manager.core.db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="UTILISATEUR")
@Entity
public class Utilisateur extends AbstractEntity {

	private String email;
	
	private String nom;
	
	private String prenom;
	
}