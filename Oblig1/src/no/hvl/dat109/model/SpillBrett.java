package no.hvl.dat109.model;

import java.util.List;

import no.hvl.dat109.model.ruter.MaalRute;
import no.hvl.dat109.model.ruter.StartRute;
/**
 * @version v.3
 * Spillbrett til bruk i applikasjonen
 * MERK IKKJE I BRUK!
 * @author June Volden
 */
public class SpillBrett extends Brett {
	private Rute start;
	private Rute maal;
	private List<Brikke> brikker;
	
	public SpillBrett(List<Rute> ruter, List<Brikke> brikker) {
		super(ruter);
		this.brikker = brikker;

		this.start = ruter.stream().filter(r -> r.getClass().equals(StartRute.class)).findFirst().orElse(null);
		this.start = ruter.stream().filter(r -> r.getClass().equals(MaalRute.class)).findFirst().orElse(null);
	}

	public Rute getStart() {
		return start;
	}

	public Rute getMaal() {
		return maal;
	}

}
