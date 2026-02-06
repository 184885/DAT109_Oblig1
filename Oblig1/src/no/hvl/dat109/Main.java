package no.hvl.dat109;

import no.hvl.dat109.service.SpillService;

public class Main {
/**
 * Klasse for å spille stigespillet
 * @author June Volden
 */

	private static SpillService service = new SpillService();
	public static void main(String[] args) {

		try{
		service.init();
		service.spill();
		}finally {
			service.close();	
		}
	}
	
}
