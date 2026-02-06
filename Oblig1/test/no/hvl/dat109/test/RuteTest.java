package no.hvl.dat109.test;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.ruter.StartRute;
import no.hvl.dat109.v2.entitet.FlyttStartRute;
import no.hvl.dat109.v2.entitet.MaalRute2;
import no.hvl.dat109.v2.entitet.StartRute2;
import no.hvl.dat109.v2.entitet.VanligRute2;

/**
 * Tester ruten.
 * 
 * @author Leah Hagen Monsen
 */

public class RuteTest {
	
	Rute start = new StartRute2();
	Rute maal = new MaalRute2();
	Rute flytte = new FlyttStartRute();
	Rute vanlig = new VanligRute2();
	
	/**
	 * Tester start rute og sørger for at den gjør det den skal.
	 */
	
	@Test
	void testStartPaaBrettet() {
		//TODO - 
		
	}
	
	/**
	 * Tester mål rute og sørger for at den gjør det den skal.
	 */
	
	@Test
	void testMaalPaaBrettet() {
		//TODO
	}
	
	/**
	 * Tester flytte rute og sørger for at den gjør det den skal.
	 */
	
	@Test
	void testFlyttePaaBrettet() {
		//TODO
	}
	
	/**
	 * Tester vanlig rute og sørger for at den gjør det den skal.
	 */
	
	@Test
	void testVanligPaaBrettet() {
		//TODO
	}
}
