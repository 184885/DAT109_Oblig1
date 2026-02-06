package no.hvl.dat109.model;

/**
 * Simulerer ein spiller.
 * 
 * @author June Volden
 * @author Brage Brekkeflat
 * @author Leah Hagen Monsen
 */
public class Spiller {
	private String navn;
	private boolean iFengsel;
	private Brikke brikke;
	private int rute;
	private int sum;
	private String tekst;

	public Spiller() {
		this.navn = "Spiller";
		this.iFengsel = false;
		this.brikke = new Brikke();
	}

	public Spiller(int nummer) {
		this.navn = "Spiller " + nummer;
		this.brikke = new Brikke();
		this.iFengsel = false;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public boolean isFengsel() {
		return iFengsel;
	}

	/**
	 * Spiller gjør eit trekk i stigespillet
	 * 
	 * @param kopp
	 * @param brett
	 */
	public String spillTrekk(Kopp kopp, Brett brett) {

		sum = 0;

		while (sum % 6 == 0 && sum != 18) {
			kopp.trill();
			sum = sum + kopp.getSum();
		}

		// skjekker om personen havnet i fengsel eller fremdeles er i fengsel
		int skjekk = 0;
		if (!iFengsel) {
			fengsel(sum);
			if (iFengsel) {
				brikke.flyttFengsel(brett.finnRute(1));
				skjekk = 1;
			}
		}
		if (iFengsel && skjekk == 0) {
			// brikke.flyttFengsel(brett.finnRute(1));
			sum -= 6;
			if (sum != 0 || sum != 12) {
				sum = 0;
				skjekk = -1;
			}
			iFengsel = false;
		}

		Rute plass = brikke.getRute();

		if (!brett.gyldigRute(plass, sum)) {
			sum = 0;
		}
		Rute nyPlass = brett.finnRute(plass, sum);
		brikke.setRute(nyPlass.landetPaa());
		rute = brikke.getRute().getId();

		if (!iFengsel) {
			tekst = navn + " har flyttet " + sum + " ruter. Spilleren er nå på rute: " + rute;
		}
		if (skjekk == -1) {
			tekst = "Spilleren er fremdeles i fengsel";
		}

		if (rute == 100) {
			tekst = (navn + " har vunnet, og de siste spillerene " + "får en siste runde!");
		}
		String svar = tekst;
		tekst = "";

		return svar;
	}

	/**
	 * Sjekker om spiller har trillet 3 seksere på rad. Plasserer isåfall Brikke på
	 * fengsel ruten (ute av spill)
	 */
	private void fengsel(int sum) {
		iFengsel = false;
		if (sum >= 18) {
			sum = 0;
			rute = 1;
			iFengsel = true;
			if (tekst.equals("")) {
				tekst = "Spilleren har havnet i fengsel og er på rute 1";
			}
		}
	}

	/**
	 * Flytter brikke viss sum+rute <100 Viss det blir større så returneres kun
	 * orginal rute
	 */

	public int flyttBrikke(int rute, int sum) {

		if (rute + sum > 100) {
			return rute;
		}
		if (iFengsel) {
			return 1;
		}
		return rute + sum;
	}

	/**
	 * Sjekker om spiller har vunnet spillet
	 * 
	 * @return om spiller har vunnet spillet når en spiller har vunnet vil de andre
	 *         spillerene kunne fullføre runden sinn
	 */
	public boolean spillVunnet() {
		if (rute == 100) {

			return true;
		}
		return false;
	}
}
