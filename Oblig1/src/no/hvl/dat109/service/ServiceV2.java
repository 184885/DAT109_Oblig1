package no.hvl.dat109.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat109.Passwords;
import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.SpillBrett;
import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.repo.RuteRepo2;

/**
 * Service for å kommunisere med spillet og databasen Kan sammenslåast med
 * SpillService.
 * 
 * @version v.2.0
 * @author June Volden
 */
public class ServiceV2 {

	private EntityManagerFactory emf;
	private RuteRepo2 ruteRepo;

	private Stigespill spill;

	public ServiceV2() {
		emf = Persistence.createEntityManagerFactory("stigespillV2",
				Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));

		ruteRepo = new RuteRepo2(emf);
	}

	public Stigespill getSpill() {
		return spill;
	}

	public void setSpill(Stigespill spill) {
		this.spill = spill;
	}

	/**
	 * Initialiserer spillet, og starte alle spillere på startrute
	 */
	public void init() {
		List<Brikke> brikker = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			brikker.add(new Brikke());
		}

		SpillBrett brett = new SpillBrett(ruteRepo.findBrett(1).getRuter2(), brikker);
		spill = new Stigespill(brett);
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

	/**
	 * Lukke tilkobling til databasen
	 */
	public void close() {
		emf.close();
	}
}
