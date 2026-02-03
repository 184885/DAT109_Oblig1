package no.hvl.dat109.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dat109_o1")
public class DType {
	@Id
	private Integer ruteID;
	private String navn;
}
