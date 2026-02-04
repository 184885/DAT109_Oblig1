package no.hvl.dat109.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

/**
 * @author June Volden
 */
@MappedSuperclass
public abstract class Rute {

	private int ruteID;
	
<<<<<<< HEAD
	private Brett brett;
=======
	  private Brett brett;
>>>>>>> 575f8c6 (superklasse til entiteter)

	private DType type;

	
	public int getId() {
		return ruteID;
	}

	public Brett getBrett() {
		return brett;
	}

	public DType getType() {
		return type;
	}

	protected abstract Rute landetPaa();

}
