package no.hvl.dat109.v2.entitet;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.model.DType;
import no.hvl.dat109.model.entity.Rute_v1;
/**
 * Forhold i databasen
 * 
 * @author June Volden
 */

@Entity(name="dtype")
@Table(schema = "dat109_o1_v2")
public class DType2 extends DType{
	@Id
	private Integer id;
	private String navn;
	
	@OneToMany(mappedBy="type")
	private List<Rute2> ruter;
}
