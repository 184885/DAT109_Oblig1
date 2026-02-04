package no.hvl.dat109.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Kopp;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Terning;

/**
 * Tester spillerene.
 * 
 * @author Leah Hagen Monsen
 */

public class SpillerTest {

	Spiller spiller = new Spiller();
	Kopp kopp = new Kopp();
	Brett brett = new Brett();
	
	Terning terningAlltidSeks = new Terning() {
		public void trill() {}
		public int getVerdi() {return 6;}
	};
	
	Kopp koppAlltidSeks = new Kopp(terningAlltidSeks);
	
	
	
	/*
	 * Test på spilltrekk. Kopp triller og brikke flytter.
	 */
	
	@Test
	void spillTrekkTest() {
		//Lagrer ruten brikken var på før trekket.
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
		assertFalse(spiller.isFengsel());
		
		//Spiller kaster tre seksere.
		spiller.spillTrekk(koppAlltidSeks, brett);
		
		//Spiller skjekker fengsel metode.
		//iFengsel = true
		assertTrue(spiller.isFengsel());
		assertTrue(spiller.getBrikke().getRute() == null);
	}
}
