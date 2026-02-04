package no.hvl.dat109.v2.entitet;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.v2.abstr.AbsBrett;

/**
* @author June Volden
*/
@Entity(name="brett")
@Table(schema = "dat109_o1_v2")
public class Brett2 extends AbsBrett{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "brett")
	private List<Rute2> ruter;

	// Konstruktør
	public Brett2() {
	}
	public Brett2(List<Rute2> ruter) {
		this.ruter = ruter;
	}

	// Get metoder
	public List<Rute2> getRuter() {
		return ruter;
	}

	/**
	 * Sjekker om ruta er gyldig. Sjekker at spiller ikkje passerer mål.
	 * @param sum 
	 * @return 
	 */
	public boolean gyldigRute(Rute2 rute, int sum) {
		return finnRute(rute, sum) != null;
	}

	/**
	 * Finner rute på brettet
	 * @param sum 
	 * @param plass 
	 * @return 
	 */
	public Rute2 finnRute(Rute2 plass, int sum) {
		int id = plass.getId();
		int nyId = id+sum;
		return finnRute(nyId);
	}
/**
 * Finner rute med gitt id 
 * @param id
 * @return rute
 */
	public Rute2 finnRute(int id) {
		return ruter.stream().filter(r->r.getId()==id).findAny().orElse(null);
	}
}
