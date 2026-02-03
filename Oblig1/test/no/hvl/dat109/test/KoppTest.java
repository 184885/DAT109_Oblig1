package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Kopp;
import no.hvl.dat109.model.Terning;

/**
 * Tester koppen som triller terninger.
 * 
 * @author Leah Hagen Monsen
 */

public class KoppTest {

	Kopp kopp = new Kopp();
	Terning terningAlltidSeks = new Terning() {
		public void trill() {}
		
		public int getVerdi() {return 6;}
	};
	Kopp koppAlltidSeks = new Kopp(terningAlltidSeks);
	
	/**
	 * Tester trill til koppen. Sjekker om den triller på nytt om terning verid = 6
	 * og ser om den stopper etter tre kast.
	 */
	
	@Test
	void testTrill() {
		
		//Tester om verdien er innenfor.
		kopp.trill();
		List<Integer> alleMuligeVerdi = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
		assertTrue(alleMuligeVerdi.contains(kopp.getSum()));
		kopp.trill();
		assertTrue(alleMuligeVerdi.contains(kopp.getSum()));
		
		//Tester om den treffer 6 og triller på nytt.
		
		
		//Tester om den har trillet 6 tre ganger. (6 * 3 = 18).
		koppAlltidSeks.trill();
		assertTrue(koppAlltidSeks.getSum() == 18);
	}
}
