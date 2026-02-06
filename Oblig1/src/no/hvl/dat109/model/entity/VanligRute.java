package no.hvl.dat109.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * Utvida rutetype vanlig rute
 *
 * @version v.1.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("1")
public class VanligRute extends Rute_v1{

	@Override
	protected Rute_v1 landetPaa() {
		return this;
	}

}
