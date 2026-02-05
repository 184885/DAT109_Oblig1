package no.hvl.dat109.v2.entitet;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.service.Remake;

/**
* @author June Volden
*/
@Entity(name="brett")
@Table(schema = "dat109_o1_v2")
public class Brett2 extends Brett{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String navn;

	@OneToMany(mappedBy = "brett", fetch = FetchType.EAGER)
	private List<Rute2> ruter;

	// Konstruktør
	public Brett2() {
	}
	public Brett2(List<Rute2> ruter) {
		this.ruter = ruter;
	}
	@Override
	public List<Rute> getRuter() {
		super.setRuter(Remake.makeRute2(ruter));
		return super.getRuter();
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
public List<Rute2> getRuter2() {

	return ruter;
}
}
