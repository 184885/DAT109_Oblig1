package no.hvl.dat109.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Simulerer eit brett i stigespillet
 * 
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
public class Brett {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "brett")
	private List<Rute> ruter;

	public Brett() {

	}

	public Brett(List<Rute> ruter) {
		this.ruter = ruter;
	}

	/**
	 * Sjekker om ruta er gyldig. Sjekker at spiller ikkje passerer mål.
	 * @param sum 
	 * @return 
	 */
	public boolean gyldigRute(Rute rute, int sum) {
		//TODO Lag metode
		return true;
	}

	/**
	 * Finner rute på brettet
	 * @param sum 
	 * @param plass 
	 * @return 
	 */
	public Rute finnRute(Rute plass, int sum) {
		//TODO
		return null;
	}
}
