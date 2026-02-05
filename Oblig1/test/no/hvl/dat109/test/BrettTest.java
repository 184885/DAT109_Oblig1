package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.ruter.MaalRute;
import no.hvl.dat109.model.ruter.StartRute;
import no.hvl.dat109.model.ruter.VanligRute;

/**
 * Tester brettet og skjekker hva som er på rutene eller hva ruten er.
 * 
 * @author Leah Hagen Monsen
 */

public class BrettTest {

	Brett brett = new Brett();
	Brikke brikke = new Brikke();
	Rute startRute = new StartRute();
	Rute maalRute = new MaalRute();
	Rute vanligRute = new VanligRute();
	List<Rute> brettetsRuter = brett.getRuter();
	
	/**
	 * Tester om startruten på brettet er riktig representert.
	 */
	
	//TODO - Vet ikke hvor ting på brettet skal være (om ruten er stige eller slange)
	
	@Test
	void testStartRute() {
		//Startrute på brettet
		Rute brettetsStartRute = brett.getRuter().getFirst();
		assertTrue(brettetsStartRute.equals(startRute) && brettetsStartRute.getId() == 1);
	}
	
	/**
	 * Tester om målruten på brettet er riktig representert.
	 */
	
	@Test
	void testMaalRute() {
		//Målrute på brettet
		Rute brettetsMaalRute = brett.getRuter().getLast();
		assertTrue(brettetsMaalRute.equals(maalRute) && brettetsMaalRute.getId() == 100);
	}
	
	/**
	 * Tester om slanger på brettet er riktig representert.
	 */
	
	@Test
	void testSlangeRuter() {
		//TODO - vet ikke hvor slangene er plassert
		List<Rute> brettetsSlanger = brettetsRuter.stream().filter(x -> x.isSlange()).toList();
	}
	
	/**
	 * Tester om stiger på brettet er riktig representert.
	 */
	
	@Test
	void testStigeRuter() {
		//TODO - vet ikke hvor stigene er plassert
		List<Rute> brettetsStiger = brettetsRuter.stream().filter(x -> x.isStige()).toList();
	}
	
	@Test
	void testVanligeRuter() {
		//TODO - kan ikke finne vanlige ruter om det ikke er
		//noen stiger eller slanger plassert.
		List<Rute> brettetsVanligeRuter = brettetsRuter.stream().filter(x -> !x.isSlange && !x.isStige).toList();
		brettetsVanligeRuter.remove(startRute);
		brettetsVanligeRuter.remove(maalRute);
		
		
	}
	
	
	/**
	 * Tester om en brikke på brettet ikke kan gå "forbi" brettet.
	 */
	
	@Test
	void testGyldigRute() {
		//TODO - 
		Rute gyldigPlass = brett.finnRute(90);
		assertTrue(brett.gyldigRute(gyldigPlass, 10));
	}
}
