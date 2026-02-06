package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Utvida rutetype målrute
 *
 * @version v.2.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1_v2")
@DiscriminatorValue("1")
public class VanligRute2 extends Rute2 {

	@Override
	protected Rute2 landetPaa() {
		return this;
	}

}
