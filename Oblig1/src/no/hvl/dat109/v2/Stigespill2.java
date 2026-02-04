package no.hvl.dat109.v2;

import java.util.List;

import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Stigespill;

public class Stigespill2 extends Stigespill {
	private SpillBrett brett;
	private boolean vunnet;

	public Stigespill2(SpillBrett brett) {
		super();
		this.brett = brett;
		List<Spiller> spillere = super.getSpillere();
		List<Brikke> brikker = brett.getBrikker();
		for (Spiller s : spillere) {
			s.setBrikke(brikker.removeFirst());
		}
		this.vunnet = false;
	}

	
	/**
	 * Starter eit spill stigespill
	 */
	public void spill() {
		//Setter alle spillerbrikker på start

		for(Spiller spiller:super.getSpillere()) {
			spiller.getBrikke().setRute(brett.getStart());
		}
		
		while(!vunnet) {
			spillRunde();
		}
	}
	
	/**
	 * Spiller ein runde av stigespillet
	 */
	private void spillRunde() {
		for(Spiller spiller:super.getSpillere()) {
			System.out.println(spiller.spillTrekk(super.getKopp(), brett));
			spillVunnet(spiller);
		}
	}
	/**
	 * Sjekker om ein spiller har vunnet spillet
	 */
	private void spillVunnet(Spiller s) {
		if(!vunnet) {
			//TODO privat rute maal?

			vunnet = brett.getMaal().equals(s.getBrikke().getRute());
		}
	}
}
