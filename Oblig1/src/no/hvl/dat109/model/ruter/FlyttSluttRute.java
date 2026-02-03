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
@DiscriminatorValue("6")
public class FlyttSluttRute extends Rute{

	@Override
	protected void landetPaa() {
	}
}
