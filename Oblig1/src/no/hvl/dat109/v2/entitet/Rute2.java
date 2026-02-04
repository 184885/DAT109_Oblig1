package no.hvl.dat109.v2.entitet;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import no.hvl.dat109.model.Rute;
/**
* @author June Volden
*/
@Entity(name = "rute")
@Table(schema = "dat109_o1_v2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rute_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Rute2 extends Rute{
	@Id
	private int ruteID;
	
	@ManyToOne
	@JoinColumn(name = "brettID")
	  private Brett2 brett;

	@ManyToOne
	@JoinColumn(name = "rute_type")
	private DType2 type;

	@OneToOne(mappedBy = "start")
	private List<Flytt> startFlytt;
	
	@OneToMany(mappedBy="slutt")
	private List<Flytt> flytt;
	
	public int getId() {
		return ruteID;
	}

	public Brett2 getBrett() {
		return brett;
	}

	public DType2 getType() {
		return type;
	}

	protected abstract Rute2 landetPaa();

	

}
