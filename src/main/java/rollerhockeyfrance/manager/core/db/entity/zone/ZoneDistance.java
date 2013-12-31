package rollerhockeyfrance.manager.core.db.entity.zone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.constraints.NotEmpty;

import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="ZONE_DISTANCE")
@Entity
public class ZoneDistance extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "ville_1")
	@NotEmpty
	private ZoneVille ville1;
	
	@ManyToOne
	@JoinColumn(name = "ville_2")
	@NotEmpty
	private ZoneVille ville2;
	
	@NotEmpty
	@Column
	private float distance;

}
