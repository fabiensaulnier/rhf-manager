package rollerhockeyfrance.manager.core.db.entity.zone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="ZONE_VILLE")
@Entity
@JsonInclude(Include.NON_NULL)
public class ZoneVille extends AbstractEntity {
	
	@JsonProperty
	@Column
	private String libelle;
	
	@JsonProperty
	@Column(name="code_postal")
	private String codePostal;
	
	@JsonProperty
	@Column
	private Float latitude;
	
	@JsonProperty
	@Column
	private Float longitude;

}
