package no.hvl.dat109.model;

/**
 * Simulerer ein spiller.
 * 
 * @author June Volden
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
		this.iFengsel = false;
	}

	/**
	 * Spiller gjør eit trekk i stigespillet
	 * 
	 * @param kopp
	 * @param brett
	 */
	public void spillTrekk(Kopp kopp, Brett brett) {
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

	/**
	 * Sjekker om spiller har vunnet spillet
	 * 
	 * @return om spiller har vunnet spillet
	 */
	public boolean spillVunnet() {
		// TODO Auto-generated method stub
		return false;
	}

}
