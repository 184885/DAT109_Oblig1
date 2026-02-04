package no.hvl.dat109.model;

import java.util.List;

import jakarta.persistence.MappedSuperclass;
/**
 * Forhold i databasen
 * 
 * @author June Volden
 */

@MappedSuperclass
public class DType {

	private Integer id;
	private String navn;
	

	private List<Rute> ruter;

	public Integer getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public List<Rute> getRuter() {
		return ruter;
	}
	
	
	
}
