package no.hvl.dat109.v2;

import java.util.List;

import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.v2.entitet.Brett2;
import no.hvl.dat109.v2.entitet.MaalRute2;
import no.hvl.dat109.v2.entitet.Rute2;
import no.hvl.dat109.v2.entitet.StartRute2;
/**
 * @version v.3
 * Spillbrett til bruk i applikasjonen
 * MERK IKKJE I BRUK!
 * @author June Volden
 */
public class SpillBrett extends Brett2 {
	private Rute start;
	private Rute maal;
	private List<Brikke> brikker;
	
	public SpillBrett(List<Rute2> ruter, List<Brikke> brikker) {
		super(ruter);
		this.brikker = brikker;

		this.start = ruter.getFirst();
		this.maal = ruter.getLast();

//		this.start = ruter.stream().filter(r -> r.getClass().equals(StartRute2.class)).findFirst().orElse(null);
//		this.maal = ruter.stream().filter(r -> r.getClass().equals(MaalRute2.class)).findFirst().orElse(null);
	}

	public Rute getStart() {
		return start;
	}

	public Rute getMaal() {
		return maal;
	}

}
