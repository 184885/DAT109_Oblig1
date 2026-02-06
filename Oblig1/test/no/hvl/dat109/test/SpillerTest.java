package no.hvl.dat109.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import jakarta.persistence.EntityManagerFactory;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Kopp;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Terning;
import no.hvl.dat109.model.entity.VanligRute;
import no.hvl.dat109.repo.RuteRepo2;

/**
 * Tester spillerene.
 * 
 * @author Leah Hagen Monsen
 */

//@ExtendWith(MockitoExtension.class)
public class SpillerTest {

	Spiller spiller = new Spiller();
	Kopp kopp = new Kopp();
	//TODO - rutene må mockes fordi de har ingen andre måter å generere id
	@Mock private EntityManagerFactory emf;
	@Mock @InjectMocks private RuteRepo2 ruterepo = new RuteRepo2(emf);
	List<Rute> ruter = ruterepo.findAll();
	Brett brett = new Brett(ruter);
	
	Terning terningAlltidSeks = new Terning() {
		public void trill() {}
		public int getVerdi() {return 6;}
	};
	
	Kopp koppAlltidSeks = new Kopp(terningAlltidSeks);
	
	Terning terningAlltidEn = new Terning() {
		public void trill() {}
		public int getVerdi() {return 1;}
	};
	
	Kopp koppAlltidEn = new Kopp(terningAlltidEn);
	
	
	
	/*
	 * Test på spilltrekk. Kopp triller og brikke flytter.
	 */
	
	@Test
	void spillTrekkTest() {
		//Lagrer ruten brikken var på før trekket.
		Rute start = brett.finnRute(1);
		spiller.getBrikke().setRute(start);		
		int rutenFoerTrekk = spiller.getBrikke().getRute().getId();
		spiller.spillTrekk(kopp, brett);
		
		//Ser om spiller sin brikke har flyttet og terning har trillet.
		assertTrue(spiller.getBrikke().getRute().getId() != rutenFoerTrekk && kopp.getSum() > 0);
	}
	
	/**
	 * Test på om spiller er i fengsel. Først isFengsel() = false også setter vi spiller i fengsel
	 * etter å ha trillet tre seksere på rad (isFengsel() = true).
	 */
	
	@Test
	void fengselTest() {
		//Spiller skjekker fengsel metode.
		//iFengsel = false
		Rute start = brett.finnRute(1);
		spiller.getBrikke().setRute(start);
		assertFalse(spiller.isFengsel());
		
		//Spiller kaster tre seksere.
		spiller.spillTrekk(koppAlltidSeks, brett);
		
		//Spiller skjekker fengsel metode.
		//iFengsel = true
		assertTrue(spiller.isFengsel());
		assertTrue(spiller.getBrikke().getRute().getId() == 1);
		
		//Gjør et trekk og ser om spiller er fortsatt i fengsel.
		spiller.spillTrekk(koppAlltidEn, brett);
		assertTrue(spiller.getBrikke().getRute().getId() == 1);
	}
}
