package no.hvl.dat109.service;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat109.Passwords;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.repo.RuteRepo;

/**
 * Service for å kommunisere med spillet
 */

public class SpillService {
	private EntityManagerFactory emf;
	private RuteRepo ruteRepo;


	private Stigespill spill;

	public SpillService() {
		emf = Persistence.createEntityManagerFactory("stigespillPersistenceUnit",
				Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));

		ruteRepo = new RuteRepo(emf);
	}
	
	private List<Rute> finnAlleRuter() {
		return ruteRepo.findAll();
	}

	/**
	 * Initialiserer spillet
	 */
	public void init() {
		spill = new Stigespill(ruteRepo.findBrett(1));
	}

	/**
	 * Starter spillet
	 */
	public void spill() {
		if (spill == null) {
			init();
		}
		spill.spill();
	}

	public void close() {
		emf.close();
	}
}
