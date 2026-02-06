package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Simulerer ein slange
 * 
 * @version v.2.0
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1_v2")
@DiscriminatorValue("7")
public class Slange extends Flytt {

}
