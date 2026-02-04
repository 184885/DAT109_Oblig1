package no.hvl.dat109.repo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.entity.Brett_v1;
import no.hvl.dat109.model.entity.Rute_v1;

/**
 * Klasse for å kontakte database Rute er T Integer er id
 *
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
	public List<Rute> findAll() {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "select r from Rute r";

		try {
			TypedQuery<Rute> query = em.createQuery(jpqlQuery, Rute_v1.class);
			return query.getResultList();
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

	public Brett findBrett(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Brett_v1.class, id);
		} finally {
			em.close();
		}
	}
}
