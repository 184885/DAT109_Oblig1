package no.hvl.dat109.model.ruter;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;
/**
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("3")
public class MaalRute extends Rute{

	@Override
	protected Rute landetPaa() {
		return this;
	}

}
