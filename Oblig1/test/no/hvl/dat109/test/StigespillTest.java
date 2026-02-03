package no.hvl.dat109.test;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Stigespill;

/**
 * Tester Stigepill.
 * 
 * @author Leah Hagen Monsen
 */

public class StigespillTest {

	Brett brett = new Brett();
	Stigespill stigespill = new Stigespill(brett);
	
	/**
	 * Tester spill, skjekker om brikke har flyttet og om spill har avsluttet.
	 */
	
	@Test
	void testSpill() {
		stigespill.spill();
		//TODO - mangler 
	}
	
	/**
	 * Tester om en runde blir spilt.
	 */
	
	@Test
	void spillRunde() {
		//TODO - mangler
	}
	
}
