package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Spiller;

/**
 * Tester spillerene.
 * 
 * @author Leah Hagen Monsen
 */

public class SpillerTest {

	Spiller spiller = new Spiller();
	
	
	
	/*
	 * Test på spilltrekk. Kopp triller og brikke flytter.
	 */
	
	@Test
	void spillTrekkTest() {
		//TODO - mangler metoder fra spiller.
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
		//TODO - mangler metoder fra spiller.
		//Spiller skjekker fengsel metode.
		//iFengsel = false
		assertFalse(spiller.isFengsel());
		
		//Spiller kaster tre seksere.
		spiller.spillTrekk(koppAlltidSeks, brett);
		spiller.fengsel(koppAlltidSeks.getSum());
		
		//Spiller skjekker fengsel metode.
		//iFengsel = true
		assertTrue(spiller.isFengsel());
		assertTrue(spiller.getBrikke().getRute().getId == 1);
	}
}
