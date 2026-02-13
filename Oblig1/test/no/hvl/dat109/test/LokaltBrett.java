package no.hvl.dat109.test;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.model.Rute;
import no.hvl.dat109.v2.entitet.MaalRute2;
import no.hvl.dat109.v2.entitet.StartRute2;
import no.hvl.dat109.v2.entitet.VanligRute2;

public class LokaltBrett {

	public static List<Rute> getRuter() {
		List<Rute> liste = new ArrayList<>();
		Rute startRute = new StartRute2();
		startRute.setId(1);
		Rute vinnerRute = new MaalRute2();
		vinnerRute.setId(100);
		liste.add(startRute);
		liste.add(vinnerRute);
		for (int i = 2; i < 100; i++) {
			Rute r = new VanligRute2();
			r.setId(i);
			liste.add(r);
		}
		return liste;
	}
}
