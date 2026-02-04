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
	 */
	public void gyldigRute(Rute rute) {

	}

	/**
	 * Finner rute på brettet
	 */
	public void finnRute() {
		
	}
}
