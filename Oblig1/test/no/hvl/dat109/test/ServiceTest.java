package no.hvl.dat109.test;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.v2.ServiceV2;
import no.hvl.dat109.model.SpillBrett;

/**
 * Tester service.
 * 
 * @author Leah Hagen Monsen
 */

public class ServiceTest {

	@Mock ServiceV2 service = new ServiceV2();
	Stigespill spill;
	SpillBrett brett;
	
	
	/**
	 * Ser om init-metoden setter opp riktig mengde brikker og setter dem på riktig sted
	 */
	
	@Test
	void testInit() {
		//Kjører init
		service.init();
		
		//Ser om det er 4 brikker
		assertTrue(service.getSpill().getBrikker().size() == 4);
		
		//Ser om alle brikker er på startruten
		assertTrue(service.getSpill().getBrikker());
	}
}
