package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;
/**
* @author June Volden
*/
@Entity
@Table(schema = "dat109_o1_v2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rute_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Rute2 extends Rute{

	

}
