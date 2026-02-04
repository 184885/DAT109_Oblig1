package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * Simulerer ein slange
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1")
@DiscriminatorValue("8")
public class Stige extends Flytt {

}
