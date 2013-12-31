package rollerhockeyfrance.manager.core.db.entity.zone;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="ZONE_REPARTITION")
@Entity
public class ZoneRepartition extends AbstractEntity {
	
	@Column
	private String libelle;
	
	@Column
	private String description;
	
	@CollectionTable(name = "ZONE_POULE_COLLECTION", joinColumns = @JoinColumn())
	@ElementCollection(fetch = FetchType.LAZY)
	@Column
	private Collection<ZonePoule> poules;

}
