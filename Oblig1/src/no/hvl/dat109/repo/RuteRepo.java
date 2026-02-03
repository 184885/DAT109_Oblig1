package no.hvl.dat109.repo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat109.model.Rute;

/**
 * Klasse for å kontakte database Rute er T Integer er id
 *
 * @author June Volden
 */
@SuppressWarnings("rawtypes")
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
			TypedQuery<Rute> query = em.createQuery(jpqlQuery, Rute.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
/**
 * Finner rute gitt id
 * @param id
 * @return
 */
	public Rute findById(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Rute.class, id);
		} finally {
			em.close();
		}
	}

	/**
	 * Finner sluttrute gitt startrute
	 * 
	 * @param id_start
	 * @return sluttrute
	 */
	public Rute findSlutt(int id_start) {
		EntityManager em = emf.createEntityManager();
		String jpqlQuery = """
				select r
				from Rute r,
				r.flytt f
				where f.start like :id_start
				and r.ruteID like f.slutt
				""";

		try {
			TypedQuery<Rute> query = em.createQuery(jpqlQuery, Rute.class);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return em.find(Rute.class, id_start);
		} finally {

			em.close();
		}
	}

}
