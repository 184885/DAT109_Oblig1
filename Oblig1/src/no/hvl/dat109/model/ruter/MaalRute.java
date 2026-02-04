package no.hvl.dat109.model.ruter;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.entity.Rute_v1;
/**
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("3")
public class MaalRute extends Rute_v1{

	@Override
	protected Rute_v1 landetPaa() {
		return this;
	}

}
