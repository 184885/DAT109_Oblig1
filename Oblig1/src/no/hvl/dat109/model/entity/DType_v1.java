package no.hvl.dat109.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.model.DType;
/**
 * Forhold i databasen
 * 
 * @author June Volden
 */

@Entity(name="dtype")
@Table(schema = "dat109_o1")
public class DType_v1 extends DType{
	@Id
	private Integer id;
	private String navn;
	
	@OneToMany(mappedBy="type")
	private List<Rute_v1> ruter;
	
	
	
}
