package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import no.hvl.dat109.model.Brikke;
import no.hvl.dat109.model.SpillBrett;
import no.hvl.dat109.model.Stigespill;
import no.hvl.dat109.service.ServiceV2;

/**
 * Tester service.
 * 
 * @author Leah Hagen Monsen
 */

public class ServiceTest {

	@Mock ServiceV2 service = new ServiceV2();
	Stigespill spill;
	SpillBrett brett;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Ser om init-metoden setter opp riktig mengde brikker og setter dem på riktig sted
	 */
	
	@Test
	void testInit() {
		//Kjører init
		service.init();
		
		//Ser om det er 4 brikker

		assertTrue(service.getSpill().getBrett().getBrikker().size() == 4);
		
		//Ser om alle brikker er på startruten
		List<Brikke> brikkene = service.getSpill().getBrett().getBrikker();
		assertTrue(brikkene.stream().allMatch(x -> x.getRute().getId() == 1));
		service.close();

	}
}
