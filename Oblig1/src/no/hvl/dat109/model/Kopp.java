package no.hvl.dat109.model;

/**
 * Simulering av kopp for stigespill
 * 
 * @author June Volden
 */
public class Kopp {
	private Terning terning;
	private int sum;

	public Kopp() {
		this.terning = new Terning();
		this.sum = 0;
	}

	public int getSum() {
		return sum;
	}
	
	/**
	 * Triller terning eit gitt antall gonger. Havner terningen på 6 trilles den
	 * igjen og neste verdi legges til summen. Repeteres etter nødvendighet eller
	 * terningen er trillet 3 ganger.
	 */
	public void trill() {
		sum = 0;
		while (sum % 6 == 0 && sum < 18) {
			terning.trill();
			sum += terning.getVerdi();
		}
	}

}
