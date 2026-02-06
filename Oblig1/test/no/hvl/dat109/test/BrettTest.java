package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityManagerFactory;
import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.Kopp;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Terning;
import no.hvl.dat109.model.ruter.MaalRute;
import no.hvl.dat109.model.ruter.StartRute;
import no.hvl.dat109.model.ruter.VanligRute;
import no.hvl.dat109.v2.RuteRepo2;
import no.hvl.dat109.v2.entitet.Flytt;
import no.hvl.dat109.v2.entitet.FlyttSluttRute;
import no.hvl.dat109.v2.entitet.FlyttStartRute;
import no.hvl.dat109.v2.entitet.MaalRute2;
import no.hvl.dat109.v2.entitet.Slange;
import no.hvl.dat109.v2.entitet.StartRute2;
import no.hvl.dat109.v2.entitet.Stige;
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
	Spiller spiller = new Spiller();
	
	Rute startRute = new StartRute2();
	Rute maalRute = new MaalRute2();
	Rute vanligRute = new VanligRute2();
	Rute flyttStartRute = new FlyttStartRute();
	Rute flyttSluttRute = new FlyttSluttRute();
	Flytt stige = new Stige();
	Flytt slange = new Slange();
	
	Terning alltidSeks = new Terning() {
		public void trill() {}
		public int getVerdi() {return 6;}
	};
	
	Kopp kopp = new Kopp(alltidSeks);
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Tester om startruten på brettet er riktig representert.
	 */
	
	@Test
	void testStartRute() {
		//Startrute på brettet
		Rute brettetsStartRute = brett.getRuter().getFirst();
		assertTrue(brettetsStartRute.equals(startRute) && brettetsStartRute.getId() == 1);
		
		//Ser om spiller starter og lander på rute 1 om iFengsel=true
		spiller.flyttBrikke(brettetsStartRute.getId(), 0);
		assertTrue(spiller.getBrikke().getRute().getId() == 1);
		assertFalse(spiller.isFengsel());
		
		spiller.spillTrekk(kopp, brett);
		assertTrue(spiller.isFengsel());
		assertTrue(spiller.getBrikke().getRute().getId() == 1);
	}
	
	/**
	 * Tester om målruten på brettet er riktig representert.
	 */
	
	@Test
	void testMaalRute() {
		//Målrute på brettet
		Rute brettetsMaalRute = brett.getRuter().getLast();
		assertTrue(brettetsMaalRute.equals(maalRute) && brettetsMaalRute.getId() == 100);
		
		//Når en spiller lander på mål, vinner spiller.
		spiller.flyttBrikke(brettetsMaalRute.getId(), 0);
		assertTrue(spiller.spillVunnet());
	}
	
	/**
	 * Tester om slanger på brettet er riktig representert.
	 */
	
	@Test
	void testSlangeRuter() {
		List<Rute> brettetsSlanger = brettetsRuter.stream().filter(x -> x.getType().getNavn() == "Slange").toList();
		brikke.setRute(brettetsSlanger.getFirst());
		
		//Sjekker om brikke blir flyttet av slange
		//TODO
		assertTrue();
	}
	
	/**
	 * Tester om stiger på brettet er riktig representert.
	 */
	
	@Test
	void testStigeRuter() {
		List<Rute> brettetsStiger = brettetsRuter.stream().filter(x -> x.getType().getNavn() == "Stige").toList();
		brikke.setRute(brettetsStiger.getFirst());
		
		//Sjekker om brikke blir flyttet av stige
		//TODO
	}
	
	/**
	 * Tester om vanlige ruter på brettet er riktig representert.
	 */
	
	@Test
	void testVanligeRuter() {
		List<Rute> brettetsFlytteRuter = brettetsRuter.stream().filter(x -> !x.getType().getNavn() == "Stige" && !x.getType().getNavn() == "Slange").toList();
		List<Rute> brettetsVanligeRuter = brettetsRuter;
		brettetsVanligeRuter.remove(brettetsFlytteRuter);
		brettetsVanligeRuter.remove(startRute);
		brettetsVanligeRuter.remove(maalRute);
		
		//Sjekker om brettet ikke gjør noe
		// - ikke mål
		// - ikke start
		// - ikke slange/stige
		
		//TODO
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
