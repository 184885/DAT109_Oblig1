package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import jakarta.persistence.EntityManagerFactory;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.ruter.MaalRute;
import no.hvl.dat109.model.ruter.StartRute;
import no.hvl.dat109.model.ruter.VanligRute;
import no.hvl.dat109.v2.RuteRepo2;
import no.hvl.dat109.v2.entitet.FlyttSluttRute;
import no.hvl.dat109.v2.entitet.FlyttStartRute;
import no.hvl.dat109.v2.entitet.MaalRute2;
import no.hvl.dat109.v2.entitet.StartRute2;
import no.hvl.dat109.v2.entitet.VanligRute2;

/**
 * Tester brettet og skjekker hva som er på rutene eller hva ruten er.
 * 
 * @author Leah Hagen Monsen
 */

public class BrettTest {

	@Mock EntityManagerFactory emf;
	@Mock @InjectMocks RuteRepo2 ruterepo = new RuteRepo2(emf);
	List<Rute> brettetsRuter = ruterepo.findAll();
	Brett brett = new Brett(brettetsRuter);
	Brikke brikke = new Brikke();
	Rute startRute = new StartRute2();
	Rute maalRute = new MaalRute2();
	Rute vanligRute = new VanligRute2();
	Rute flyttStartRute = new FlyttStartRute();
	Rute flyttSluttRute = new FlyttSluttRute();
	
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
		List<Rute> brettetsSlanger = brettetsRuter.stream().filter(x -> x.isSlange()).toList();
	}
	
	/**
	 * Tester om stiger på brettet er riktig representert.
	 */
	
	@Test
	void testStigeRuter() {
		List<Rute> brettetsStiger = brettetsRuter.stream().filter(x -> x.isStige()).toList();
	}
	
	/**
	 * Tester om vanlige ruter på brettet er riktig representert.
	 */
	
	@Test
	void testVanligeRuter() {
		List<Rute> brettetsVanligeRuter = brettetsRuter.stream().filter(x -> !x.isSlange && !x.isStige).toList();
		brettetsVanligeRuter.remove(startRute);
		brettetsVanligeRuter.remove(maalRute);
		
		
	}
	
	
	/**
	 * Tester om en brikke på brettet ikke kan gå "forbi" brettet.
	 */
	
	@Test
	void testGyldigRute() {
		//Starter på rute nr 90
		Rute gyldigPlass = brett.finnRute(90);
		
		//Test - går 10 skritt etter 90 (90 + 10 = 100, gyldig)
		assertTrue(brett.gyldigRute(gyldigPlass, 10));
		
		//Test - går 11 skritt etter 90 (90 + 11 = 101, ugyldig)
		assertFalse(brett.gyldigRute(gyldigPlass, 11));
	}
}
