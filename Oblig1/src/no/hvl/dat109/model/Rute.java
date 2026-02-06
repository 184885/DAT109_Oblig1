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

	public int getId() {
		return ruteID;
	}

	public Brett getBrett() {
		return brett;
	}

	public void setId(int ruteID) {
		this.ruteID = ruteID;
	}

	public void setBrett(Brett brett) {
		this.brett = brett;
	}

	/**
	 * Returnerer endleg rute som ein lander på.
	 * 
	 * @return endeleg rute
	 */
	protected abstract Rute landetPaa();

}
