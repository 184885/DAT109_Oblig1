package no.hvl.dat109.v2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.repo.CrudRepository;
import no.hvl.dat109.v2.entitet.Brett2;
import no.hvl.dat109.v2.entitet.Rute2;

/**
 * Klasse for å kontakte database Rute er T Integer er id
 *
 * @author June Volden
 */

public class RuteRepo2 implements CrudRepository {
	private EntityManagerFactory emf;

	/* Konstruktør */
	public RuteRepo2(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Rute> findAll() {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "select r from Rute r";

		try {
			TypedQuery<Rute2> query = em.createQuery(jpqlQuery, Rute2.class);
			List<Rute2> liste =  query.getResultList();
			List<Rute> res = new ArrayList<>();
			liste.stream().forEach(x->res.add((Rute) x));
			
			return res;

			
		} finally {
			em.close();
		}
	}

	@Override
	public Rute2 findById(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Rute2.class, id);
		} finally {
			em.close();
		}
	}

	public Brett2 findBrett(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Brett2.class, id);
		} finally {
			em.close();
		}
	}

	public List<Rute2> findAll(int id) {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = """
				select r
				from Rute r,
				r.brett b
				where b.id = :id
				""";
//				"select r from Rute2 r where r.brett like :id";

		try {
			TypedQuery<Rute2> query = em.createQuery(jpqlQuery, Rute2.class);
			query.setParameter("id", id);
			return  query.getResultList();
			
		} finally {
			em.close();
		}
	}
	public List<Rute2> findAllRuter() {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "select r from Rute r";

		try {
			TypedQuery<Rute2> query = em.createQuery(jpqlQuery, Rute2.class);
			List<Rute2> liste =  query.getResultList();

			return liste;
			
		} finally {
			em.close();
		}
	}
}

