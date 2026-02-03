package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author June Volden
 * @author Brage Brekkeflat
 * @author Leah Hagen Monsen

 */
public class Stigespill {
	// Objektvariabler
	private Kopp kopp;
	private List<Spiller> spillere;
	private Brett brett;
	private boolean vunnet;
	private final static int MAX_ANTALL = 4;
	private final static int MIN_ANTALL = 2;

	// Konstruktører
	/**
	 * @deprecated
	 * Oppretter eit spill med MAX_ANTALL spillere og eit tomt brett
	 */
	public Stigespill() {
		this.brett = new Brett();
		this.kopp = new Kopp();
		this.spillere = new ArrayList<>(MAX_ANTALL);
		for (int i = 0; i < MAX_ANTALL; i++) {
			spillere.add(new Spiller(i));
		}
		vunnet = false;
	}
	/**
	 * @deprecated
	 * Oppretter eit spill med eit gitt antall spillere 
	 * og eit tomt brett
	 * @param antallSpillere er ønska antall spillere
	 */
	public Stigespill(int antallSpillere) {
		this.brett = new Brett();
		this.kopp = new Kopp();
		int antall = Math.max(MIN_ANTALL, Math.min(antallSpillere, MAX_ANTALL));
		this.spillere = new ArrayList<>(antall);
		for (int i = 0; i < antall; i++) {
			spillere.add(new Spiller(i));
		}
		vunnet = false;
	}
	/**
	 * OBS! Bruk denne!
	 * Oppretter eit spill med MAX_ANTALL spillere og gitt brett.
	 * @param brett, liste med ønska ruter
	 */
	public Stigespill(Brett brett) {
		this.brett = brett;
		this.kopp = new Kopp();
		this.spillere = new ArrayList<>(MAX_ANTALL);
		for (int i = 0; i < MAX_ANTALL; i++) {
			spillere.add(new Spiller(i));
		}
		vunnet = false;
	}
	
	/**
	 * Starter eit spill stigespill
	 */
	public void spill() {
		//Setter alle spillerbrikker på start
		Rute start = brett.finnRute(1);
		for(Spiller spiller:spillere) {
			spiller.getBrikke().setRute(start);
		}
		
		while(!vunnet) {
			spillRunde();
		}
	}
	
	/**
	 * Spiller ein runde av stigespillet
	 */
	private void spillRunde() {
		for(Spiller spiller:spillere) {
			System.out.println(spiller.spillTrekk(kopp, brett));
			spillVunnet(spiller);
		}
	}
	/**
	 * Sjekker om ein spiller har vunnet spillet
	 */
	private void spillVunnet(Spiller s) {
		if(!vunnet) {
			vunnet = s.spillVunnet();
		}
	}
	
	/**
	 * Getters av verdier.
	 */
	
	public Kopp getKopp() {
		return kopp;
	}
	public List<Spiller> getSpillere() {
		return spillere;
	}
	public Brett getBrett() {
		return brett;
	}
	public boolean isVunnet() {
		return vunnet;
	}
	public static int getMaxAntall() {
		return MAX_ANTALL;
	}
	public static int getMinAntall() {
		return MIN_ANTALL;
	}
	
	
	

}
