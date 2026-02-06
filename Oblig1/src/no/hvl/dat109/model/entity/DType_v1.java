package no.hvl.dat109.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Enum forhold i databasen Beskriver type med navn.
 * 
 * @version v.1.0
 * @author June Volden
 */

@Entity(name = "dtype")
@Table(schema = "dat109_o1")
public class DType_v1 {
	@Id
	private Integer id;
	@SuppressWarnings("unused")
	private String navn;

	@OneToMany(mappedBy = "type")
	private List<Rute_v1> ruter;

}
