package no.hvl.dat109.model;

/**
 * Simulerer ein brikke i stigespillet
 * 
 * @author June Volden
 */
public class Brikke {
	private String navn;
	private Rute rute;

	public Brikke() {
		this.navn = "Brikke";
	}

	public String getNavn() {
		return navn;
	}
	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
	}

	/**
	 * Flytter ruten til fengsel (ut av spill)
	 */
	public void flyttFengsel() {
		rute = null;
	}


}
