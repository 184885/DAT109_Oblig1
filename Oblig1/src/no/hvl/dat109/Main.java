package no.hvl.dat109;

import no.hvl.dat109.service.SpillService;

/**
 * Klasse for å spille stigespillet, versjon utan slanger og stiger
 * 
 * @version v.1.0
 * @author June Volden
 */
public class Main {

	private static SpillService service = new SpillService();

	public static void main(String[] args) {

		try {
			service.init();
			service.spill();
		} finally {
			service.close();
		}
	}

}
