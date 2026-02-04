package no.hvl.dat109.v2;

public class Main2 {

	/**
	 * Klasse for å spille stigespillet
	 * @author June Volden
	 */

		private static ServiceV2 service = new ServiceV2();
		public static void main(String[] args) {

			service.init();
			service.close();
			service.spill();
			
		}
		
}
