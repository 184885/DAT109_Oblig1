package no.hvl.dat109.model.entity;

import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Brett;

/**
 * Simulerer eit brett i stigespillet
 * 
 * @author June Volden
 */
@Entity(name="brett")
@Table(schema = "dat109_o1")

public class Brett_v1 extends Brett{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Access(AccessType.FIELD)
	@OneToMany(mappedBy = "brett")
	private List<Rute_v1> ruter;

	
	
	// Konstruktør
	public Brett_v1() {
	}
	public Brett_v1(List<Rute_v1> ruter) {
		this.ruter = ruter;
	}


	/**
	 * Sjekker om ruta er gyldig. Sjekker at spiller ikkje passerer mål.
	 * @param sum 
	 * @return 
	 */
	public boolean gyldigRute(Rute_v1 rute, int sum) {
		return finnRute(rute, sum) != null;
	}

	/**
	 * Finner rute på brettet
	 * @param sum 
	 * @param plass 
	 * @return 
	 */
	public Rute_v1 finnRute(Rute_v1 plass, int sum) {
		int id = plass.getId();
		int nyId = id+sum;
		return finnRute(nyId);
	}
/**
 * Finner rute med gitt id 
 * @param id
 * @return rute
 */
	public Rute_v1 finnRute(int id) {
		return ruter.stream().filter(r->r.getId()==id).findAny().orElse(null);
	}
}
