package rollerhockeyfrance.manager.core.db.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe abstraite dont toutes les entités doivent hériter
 * 
 * @author fabiensaulnier
 *
 */
@Data
@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public abstract class AbstractEntity {
	
	@JsonProperty
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty
	@Column
	private DateTime created;
	
	@JsonProperty
	@Column
	private DateTime updated;

}
