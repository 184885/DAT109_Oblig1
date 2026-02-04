package no.hvl.dat109.model.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;

/**
 * @author June Volden
 */
@Entity(name="rute")
@Table(schema = "dat109_o1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rute_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Rute_v1 extends Rute{
	@Id
	private int ruteID;
	
	@ManyToOne
	@JoinColumn(name = "brettID")
	  private Brett_v1 brett;

	@ManyToOne
	@JoinColumn(name = "rute_type")
	private DType_v1 type;

	
	public int getId() {
		return ruteID;
	}

	public Brett_v1 getBrett() {
		return brett;
	}

	public DType_v1 getType() {
		return type;
	}

	protected abstract Rute_v1 landetPaa();

}
