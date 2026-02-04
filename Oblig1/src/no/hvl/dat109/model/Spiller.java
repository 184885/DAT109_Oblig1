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
		kopp.trill();
		int sum = kopp.getSum();

		fengsel(sum);
		if (iFengsel) {
			brikke.flyttFengsel();
			sum -= 6;
		if(sum<0||sum>=12) {
			sum = 0;
		}
		}
		Rute plass = brikke.getRute();
		
		if(!brett.gyldigRute(plass, sum)) {
			sum = 0;
		}
		Rute nyPlass = brett.finnRute(plass,sum);
		brikke.setRute(nyPlass.landetPaa());
		
		return navn + "har flyttet " + sum + " ruter";

	}

	/**
	 * Sjekker om spiller har trillet 3 seksere på rad. Plasserer isåfall Brikke på
	 * fengsel ruten (ute av spill)
	 */
	private void fengsel(int sum) {
		iFengsel = false;
		if (sum >= 18) {
			iFengsel = true;
			brikke.flyttFengsel();
		}
	}

}
