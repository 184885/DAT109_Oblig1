package no.hvl.dat109.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.model.Kopp;
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.model.Terning;
import no.hvl.dat109.v2.entitet.Brett2;
import no.hvl.dat109.v2.entitet.Rute2;

/**
 * Tester hele spillet og sørger for at alle regler blir følgt.
 * 
 * @author Leah Hagen Monsen
 */
public class FullStackTest {

	Terning terning = new Terning();
	Kopp kopp = new Kopp(terning);
	List<Spiller> spillere = List.of();
	List<Rute2> ruter = List.of();
	Brett2 brett = new Brett2(ruter);
	Stigespill stigespill = new Stigespill(brett);
	
	@BeforeEach
	void oppsett() {
		Rute2 start = brett.finnRute(1);
		for (Spiller spillere:spillere) {
			spillere.getBrikke().setRute(start);
		}
	}
	
	/**
	 * Tester omfattende spillet.
	 */
	
	@Test
	void testHeleSpillet() {
		//TODO
		//Skjekk om en spiller flytter og plasserer brikken på rett sted.
		
	}
}
