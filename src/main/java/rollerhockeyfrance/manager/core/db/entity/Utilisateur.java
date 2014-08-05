package rollerhockeyfrance.manager.core.db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="UTILISATEUR")
@Entity
public class Utilisateur extends AbstractEntity {

	private String email;
	
	private String nom;
	
	private String prenom;
	
}