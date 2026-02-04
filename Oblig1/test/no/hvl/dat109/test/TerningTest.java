package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Terning;

/**
 * Tester terningen
 * 
 * @author Leah Hagen Monsen
 */
public class TerningTest {

	Terning terning = new Terning();
	List<Integer> terningSidene = List.of(1,2,3,4,5,6);
	
	/**
	 * Tester trill funksjonen til terningen og skjekker om den verdien som blir trillet
	 * er innenfor 1 til 6. (sidene til terningen).
	 */
	
	@Test
	void testTrill() {
		terning.trill();
		assertTrue(terningSidene.contains(terning.getVerdi()));
	}
	
	/**
	 * Test terningen mange ganger for å skjekke om den garantert
	 * triller tall i mengden fra 1 til 6.
	 */
	
	@Test
	void testTrillMangeGanger() {
		for (int i=0; i < 1000; i++) {
			terning.trill();
			assertTrue(terningSidene.contains(terning.getVerdi()));
		}
	}
}
