package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("5")
public class FlyttStartRute extends Rute2{

	@Override
	protected Rute2 landetPaa() {
		//TODO
		return null;
	}

}
