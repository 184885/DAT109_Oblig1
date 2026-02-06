package no.hvl.dat109.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Utvida rutetype startrute
 *
 * @version v.1.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("2")
public class StartRute extends Rute_v1 {

	@Override
	protected Rute_v1 landetPaa() {
		return this;
	}

}
