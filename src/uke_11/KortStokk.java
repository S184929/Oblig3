package uke_11;

import java.util.Collections;
import java.util.LinkedList;

import uke_11.KortVerdi;
import uke_11.KortFarge;
import uke_11.Kort;

public class KortStokk {
	
	private LinkedList<Kort> kortstokk;
	
	public void kortStokk(int antall) {
		kortstokk = new LinkedList<>();
		for(KortFarge farge : KortFarge.values()) {
			for(KortVerdi verdi : KortVerdi.values()) {
				kortstokk.add(new Kort(farge, verdi));
			}
		}
		
	}
	public void Shuffle() {
		Collections.shuffle(kortstokk);
	}
	public Kort trekkKort() {
		if(!kortstokk.isEmpty()) {
			return kortstokk.removeFirst();
		} else {
			throw new IllegalStateException("Kortstokken er tom");
		}
	}
}
