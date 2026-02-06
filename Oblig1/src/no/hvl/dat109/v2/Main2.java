package no.hvl.dat109.v2;

public class Main2 {

	/**
	 * Klasse for å spille stigespillet Kan samanslåast med main. Isåfall gi bruker
	 * valg på kva spill som skal kjøres.
	 * 
	 * @version v.2.0
	 * @author June Volden
	 */

	private static ServiceV2 service = new ServiceV2();

	public static void main(String[] args) {

		service.init();
		service.close();
		service.spill();

	}

}
