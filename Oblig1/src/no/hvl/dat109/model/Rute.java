package no.hvl.dat109.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rute_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Rute {
	@Id
	private int ruteID;
	
	@ManyToOne
	@JoinColumn(name = "brettID")
	  private Brett brett;

	
	@ManyToOne
	@JoinColumn(name = "rute_type", insertable = false, updatable = false)
	private DType type;

	protected abstract Rute landetPaa();

}
