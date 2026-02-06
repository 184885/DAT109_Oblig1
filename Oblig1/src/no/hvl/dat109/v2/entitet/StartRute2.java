package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * Utvida rutetype startrute
 *
 * @version v.2.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1_v2")
@DiscriminatorValue("2")
public class StartRute2 extends Rute2{

	@Override
	protected Rute2 landetPaa() {
		//TODO
		return null;
	}

}
