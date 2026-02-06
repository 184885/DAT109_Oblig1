package no.hvl.dat109.repo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.entity.Brett_v1;
import no.hvl.dat109.model.entity.Rute_v1;

/**
 * Klasse for å kontakte database
 * 
 * @version v.1.0
 * @author June Volden
 */

public class RuteRepo implements CrudRepository {
	private EntityManagerFactory emf;

	/* Konstruktør */
	public RuteRepo() {
		emf = Persistence.createEntityManagerFactory("stigespillPersistenceUnit");
	}

	public RuteRepo(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Rute_v1> findAll() {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "select r from Rute r";

		try {

			return em.createQuery(jpqlQuery, Rute_v1.class).getResultList();

		} finally {
			em.close();
		}
	}

	@Override
	public Rute findById(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Rute_v1.class, id);
		} finally {
			em.close();
		}
	}

	/**
	 * Henter brettet fra databasen
	 * 
	 * @param brett id
	 * @return brett fra databasen
	 */
	public Brett findBrett(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Brett_v1.class, id);
		} finally {
			em.close();
		}
	}

	/**
	 * Lukker EntityManagerFactory-et
	 */
	public void close() {
		emf.close();
	}
}
