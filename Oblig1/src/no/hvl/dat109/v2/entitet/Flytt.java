package no.hvl.dat109.v2.entitet;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author June Volden
 */
@Entity
@Table(schema = "dat109_o1_v2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "flytt_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Flytt {
	@ManyToOne
	@JoinColumn(name="flytt_type", insertable=false, updatable=false)
	private DType2 type; 
	
	@Id
    @OneToOne
    @JoinColumn(name="start")
	private Rute2 start;
	
    @ManyToOne
    @JoinColumn(name="slutt")
	private Rute2 slutt;
}
