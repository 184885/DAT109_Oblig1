package no.hvl.dat109.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dat109_o1")
public class DType {
	@Id
	private Integer id;
	private String navn;
	
	@OneToMany(mappedBy="type")
	private List<Rute> ruter;
	
	
}
