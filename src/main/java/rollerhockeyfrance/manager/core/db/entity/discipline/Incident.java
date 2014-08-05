package rollerhockeyfrance.manager.core.db.entity.discipline;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.joda.time.DateTime;

import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="DISCIPLINE_INCIDENT")
@Entity
public class Incident extends AbstractEntity {
	
	private String equipeA;
	private String equipeB;
	private String lieu;
	private DateTime dateHeure;
	private String categorie;
	private String arbitre1;
	private String arbitre2;
	

}
