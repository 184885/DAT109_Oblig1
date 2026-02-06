package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Utvida rutetype flytt sluttrute. Kan vere slutt på slange eller stige
 *
 * @version v.2.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1_v2")
@DiscriminatorValue("6")
public class FlyttSluttRute extends Rute2 {

	@Override
	protected Rute2 landetPaa() {
		Flytt f = super.getStartFlytt();
		if (super.getStartFlytt() == null) {
			return this;
		}
		Rute2 res = this;
		while (f != null) {
			res = f.getSlutt();
			f = res.getStartFlytt();
		}
		return res;
	}
}
