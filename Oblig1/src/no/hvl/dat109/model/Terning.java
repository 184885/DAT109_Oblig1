package no.hvl.dat109.model;

import java.util.Random;

/**
 * Simulering av terning til stigespillet.
 * 
 * @author June Volden
 */
public class Terning {
	private int verdi;
	private Random r;
	
	public Terning() {
		this.verdi = 0;
		this.r = new Random();
	}
	
	public int getVerdi() {
		return verdi;
	}
	
	/**
	 * Triller terning
	 */
	public void trill() {
		verdi = r.nextInt(1, 6);
	}

}
