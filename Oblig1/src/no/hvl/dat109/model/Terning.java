package no.hvl.dat109.model;

import java.util.Random;

/**
 * Simulering av terning til stigespillet.
 * 
 * @author June Volden, Leah Hagen Monsen
 */
public class Terning {
	private int verdi;
	private Random r;
	private int min;
	private int max;
	
	public Terning() {
		this.verdi = 0;
		this.r = new Random();
		this.max = 6;
		this.min = 1;
	}
	
	public Terning(int min, int max) {
		this.verdi = 0;
		this.r = new Random();
		this.min = min;
		this.max = max;
	}
	
	public int getVerdi() {
		return verdi;
	}
	
	/**
	 * Triller terning
	 */
	public void trill() {
		verdi = r.nextInt(min, max);
	}

}
