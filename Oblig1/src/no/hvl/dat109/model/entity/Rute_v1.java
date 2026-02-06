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
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.DType;
import no.hvl.dat109.model.Rute;

/**
 * Simulering av rute sett fra databasen.
 * 
 * @version v.1.0
 * @author June Volden
 */
@Entity(name = "rute")
@Table(schema = "dat109_o1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rute_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Rute_v1 extends Rute {
	@Id
	private int ruteID;

	@ManyToOne
	@JoinColumn(name = "brettID")
	private Brett_v1 brett;

	@ManyToOne
	@JoinColumn(name = "rute_type")
	private DType_v1 type;

	@Override
	public int getId() {
		super.setId(ruteID);
		return ruteID;
	}

	@Override
	public Brett getBrett() {
		super.setBrett(brett);
		return (Brett) brett;
	}

	@Override
	public DType getType() {
		super.setType(type);
		return (DType) type;
	}
}
