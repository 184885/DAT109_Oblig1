package no.hvl.dat109.model;

import jakarta.persistence.MappedSuperclass;

/**
 * Simulerer ein rute i stigespillet. Her brukes polimorfi
 * 
 * @author June Volden
 */
@MappedSuperclass
public abstract class Rute {

	private int ruteID;

	private Brett brett;

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

	public void setId(int ruteID) {
		this.ruteID = ruteID;
	}

	public void setBrett(Brett brett) {
		this.brett = brett;
	}

	public void setType(DType type) {
		this.type = type;
	}

	/**
	 * Returnerer endleg rute som ein lander på.
	 * 
	 * @return endeleg rute
	 */
	protected abstract Rute landetPaa();

}
