package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Brett;
import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.model.entity.MaalRute;
import no.hvl.dat109.model.entity.StartRute;
import no.hvl.dat109.model.entity.VanligRute;

/**
 * Tester Stigepill.
 * 
 * @author Leah Hagen Monsen
 */

public class StigespillTest {
	Brett brett;
	Stigespill stigespill;
	Rute vinnerRute;

	@BeforeEach
	void nullstill() {
		Rute startRute = new StartRute();
		startRute.setId(1);
		vinnerRute = new MaalRute();
		vinnerRute.setId(100);
		List<Rute> ruter = new ArrayList<>();
		ruter.add(startRute);
		ruter.add(vinnerRute);
		for(int i=2;i<100;i++) {
			Rute r = new VanligRute();
			r.setId(i);
			ruter.add(r);
		}
		brett = new Brett(ruter);
		stigespill = new Stigespill(brett);
		
	}

	/**
	 * Tester spill, skjekker om brikke har flyttet og om spill har avsluttet.
	 */

	@Test
	void testSpill() {

		// Ser om noen har vunnet først, deretter spiller.
		assertFalse(stigespill.isVunnet());
		List<Spiller> spillere = stigespill.getSpillere();

		assertTrue(spillere.stream().allMatch(x -> x.getBrikke().getRute() == null)); // Hva om spiller er i fengsel?

		// TODO - kan ikke konfirmere om brikkene blir plassert på finnRute(1)
		stigespill.spill();
		assertFalse(spillere.stream().allMatch(x -> x.getBrikke().getRute() == null));
//		assertTrue(stigespill.getSpillere().forEach(x -> x.getBrikke().getRute().getId()) == 1);
		assertTrue(stigespill.isVunnet());
		// Finne ut om spillere spiller. (spillRunde())
	}

	/**
	 * Her simulerer vi et spill som blir vunnet med en gang.
	 */

	void testSpillVunnetMedEnGang() {

		assertFalse(stigespill.isVunnet());

		// Når noen har vunnet, sjekk om spillet er slutt.
		stigespill.getSpillere().forEach(x -> x.getBrikke().setRute(vinnerRute));

		// TODO - Har ikke måte på å finne ut om spillere flytter på seg
		// selv om spillet er slutt, dessuten kan ikke unngå å sette brikkene
		// på rute nr.1 pga. spill() metoden.
		assertTrue(stigespill.isVunnet());
		stigespill.spill(); // spill setter alle brikker på rute 1
		assertTrue(stigespill.isVunnet());

		// Finne ut om spillere spiller. (spillRunde())
	}

	/**
	 * Tester om en runde blir spilt.
	 */

	@Test
	void testSpillRunde() {
		// TODO - mangler metoder og måter å finne ut av om en runde blir spilt

		// Her må Spiller.spillTrekk() skjekke om spiller gjør et trekk.
		// Testes i SpillerTest

	}

}
