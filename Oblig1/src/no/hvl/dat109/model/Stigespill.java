package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulerer eit stigespill
 * 
 * @author June Volden
 * @author Brage Brekkeflat
 * @author Leah Hagen Monsen
 */
public class Stigespill {
	// Objektvariabler
	private Kopp kopp;
	private List<Spiller> spillere;
	private SpillBrett brett;
	private boolean vunnet;
	private final static int MAX_ANTALL = 4;
	private final static int MIN_ANTALL = 2;

	// Konstruktører
	/**
	 * Oppretter eit spill med MAX_ANTALL spillere og eit tomt brett
	 */
	public Stigespill() {
		this(MAX_ANTALL);
	}

	/**
	 * Oppretter eit spill med eit gitt antall spillere og eit tomt brett
	 * 
	 * @param antallSpillere er ønska antall spillere
	 */
	public Stigespill(int antallSpillere) {
		this.brett = new SpillBrett();
		this.kopp = new Kopp();
		int antall = Math.max(MIN_ANTALL, Math.min(antallSpillere, MAX_ANTALL));
		this.spillere = new ArrayList<>(antall);
		for (int i = 0; i < antall; i++) {
			Spiller s = new Spiller(i + 1);
			spillere.add(s);
			this.brett.getBrikker().add(s.getBrikke());
		}
		vunnet = false;
	}

	/**
	 * OBS! Bruk denne! Oppretter eit spill med MAX_ANTALL spillere og gitt brett.
	 * 
	 * @param brett, liste med ønska ruter
	 */
	public Stigespill(Brett brett) {
		this();
		this.brett = new SpillBrett(brett.getRuter(), this.brett.getBrikker());
	}

	/**
	 * Starter eit spill stigespill
	 */
	public void spill() {
		// Setter alle spillerbrikker på start
		Rute start = brett.finnRute(1);
		for (Spiller spiller : spillere) {
			spiller.getBrikke().setRute(start);
		}

		while (!vunnet) {
			spillRunde();
		}
	}

	/**
	 * Spiller ein runde av stigespillet
	 */
	private void spillRunde() {
		for (Spiller spiller : spillere) {
			System.out.println(spiller.spillTrekk(kopp, brett));
			spillVunnet(spiller);
		}
	}

	/**
	 * Sjekker om ein spiller har vunnet spillet
	 */
	private void spillVunnet(Spiller s) {
		if (!vunnet) {
			// TODO privat rute maal?
			Rute maal = brett.finnRute(100);
			vunnet = maal.equals(s.getBrikke().getRute());
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

	public SpillBrett getBrett() {
		return brett;
	}

	public boolean isVunnet() {
		return vunnet;
	}

}
