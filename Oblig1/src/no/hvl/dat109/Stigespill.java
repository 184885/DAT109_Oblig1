import java.util.ArrayList;
import java.util.List;

/**
 * Klasse for å simulere monopol
 *
 * @author June Volden
 */
public class Stigespill {
	private boolean vunnet;
	private List<Spiller> spillere = new ArrayList<>();
	private Kopp kopp;
	private Brett brett;

	public Stigespill() {
		vunnet = false;
	}

}
