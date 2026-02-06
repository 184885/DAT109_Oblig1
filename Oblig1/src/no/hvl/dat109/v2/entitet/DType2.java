package no.hvl.dat109.v2.entitet;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import no.hvl.dat109.model.entity.DType_v1;

/**
 * Enum for typer i databasen
 * 
 * @version v.2.0
 * @author June Volden
 */

@Entity(name = "dtype")
@Table(schema = "dat109_o1_v2")
public class DType2 extends DType_v1 {

}
