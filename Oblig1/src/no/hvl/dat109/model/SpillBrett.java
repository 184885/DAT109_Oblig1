package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v.2.1 
 * Spillbrett til bruk i applikasjonen
 * @author June Volden
 */
public class SpillBrett extends Brett {
	private Rute start;
	private Rute maal;
	private List<Brikke> brikker;
	private static final int startid = 1;
	private static final int maalid = 1;

	public SpillBrett() {
		this(new ArrayList<Rute>(),new ArrayList<Brikke>());
	}
	public SpillBrett(List<Rute> ruter, List<Brikke> brikker) {
		super(ruter);
		this.brikker = brikker;
		this.setRuter(ruter);

		this.start = ruter.stream().filter(r -> r.getId() == startid).findFirst().orElse(null);
		this.maal = ruter.stream().filter(r -> r.getId() == maalid).findFirst().orElse(null);
	}

	public Rute getStart() {
		return start;
	}

	public Rute getMaal() {
		return maal;
	}
	
	public List<Brikke> getBrikker() {
		return brikker;
	}
	public void setBrikker(List<Brikke> brikker) {
		this.brikker = brikker;
	}

}
