package no.hvl.dat109.repo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.entity.Brett_v1;
import no.hvl.dat109.model.entity.Rute_v1;
import no.hvl.dat109.service.Remake;

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
			
			List<Rute_v1> liste =  em.createQuery(jpqlQuery, Rute_v1.class).getResultList();
			return Remake.makeRute(liste);
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
