package rollerhockeyfrance.manager.core.db.entity.zone;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="ZONE_POULE")
@Entity
public class ZonePoule extends AbstractEntity {
	
	@Column
	private String libelle;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ElementCollection(fetch=FetchType.LAZY)
    @JoinTable(name="ZONE_VILLE")
	private Collection<ZoneVille> ville;

}
