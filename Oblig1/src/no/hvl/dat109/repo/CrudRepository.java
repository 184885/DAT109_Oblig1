package no.hvl.dat109.repo;

import java.util.List;

import no.hvl.dat109.model.Rute;

public interface CrudRepository{
	
	/**
	 * Returns all instances of the type.
	 */
	List<Rute> findAll();
	/**
	 * Finner rute gitt id
	 * @param id
	 * @return
	 */
		Rute findById(int id) ;
	
}
