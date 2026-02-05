package no.hvl.dat109.service;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.model.Rute;
import no.hvl.dat109.model.entity.Rute_v1;
import no.hvl.dat109.v2.entitet.Rute2;

/**
 * Klasse til å kaste Lister opp til tidlegare foreldre.
 * @author June Volden
 */
public class Remake {
/**
 * Omformer Entitet til vanlig type
 * @param rute
 * @return Liste av ruter
 */
	public static List<Rute> makeRute(List<Rute_v1> liste){
		List<Rute> res = new ArrayList<>();
		liste.stream().forEach(r->res.add((rute(r))));
		return res;
	}
	/**
	 * Omformer Entitet til vanlig type
	 * @param rute
	 * @return Liste av ruter
	 */
		public static List<Rute> makeRute2(List<Rute2> liste){
			List<Rute> res = new ArrayList<>();
			liste.stream().forEach(r->res.add((rute(r))));
			return res;
		}
	
	private static Rute rute(Rute_v1 r) {
		r.getBrett();
		r.getId();
		r.getType();
		return (Rute) r;
	}
	private static Rute rute(Rute2 r) {
		r.getBrett();
		r.getId();
		r.getType();
		return (Rute) r;
	}
	
}
