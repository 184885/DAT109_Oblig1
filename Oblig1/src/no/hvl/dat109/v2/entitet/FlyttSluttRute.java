package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;
/**
 * @author June Volden
 */
@Entity
<<<<<<< HEAD
@Table(schema = "dat109_o1_v2")
=======
@Table(schema = "dat109_o1")
>>>>>>> 8ed9e95 (lagt til entiter til v2 med slanger og stiger)
@DiscriminatorValue("6")
public class FlyttSluttRute extends Rute2{

	@Override
	protected Rute2 landetPaa() {
		//TODO
		return null;
	}
}
