package no.hvl.dat109.model;

import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.MappedSuperclass;

/**
 * Simulerer eit brett i stigespillet
 * 
 * @author June Volden
 */
@MappedSuperclass
public class Brett {

	private List<Rute> ruter;

	// Konstruktør
	public Brett() {
	}
	public Brett(List<Rute> ruter) {
		this.ruter = ruter;
	}

	// Get metoder
	public List<Rute> getRuter() {
		return ruter;
	}

	public void setRuter(List<Rute> ruter) {
		this.ruter = ruter;
	}
	/**
	 * Sjekker om ruta er gyldig. Sjekker at spiller ikkje passerer mål.
	 * @param sum 
	 * @return 
	 */
	public boolean gyldigRute(Rute rute, int sum) {
		return finnRute(rute, sum) != null;
	}

	/**
	 * Finner rute på brettet
	 * @param sum 
	 * @param plass 
	 * @return 
	 */

	public Rute finnRute(Rute plass, int sum) {
		if(plass == null) {
			return null;
		}
		int id = plass.getId();
		int nyId = id+sum;
		return finnRute(nyId);
	}
/**
 * Finner rute med gitt id 
 * @param id
 * @return rute
 */
	public Rute finnRute(int id) {
		return ruter.stream().filter(r->r.getId()==id).findAny().orElse(null);

	}
}
