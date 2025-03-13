package uke_11;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import uke_11.KortVerdi;
import uke_11.KortFarge;
import uke_11.Kort;

public class KortStokk implements Iterable<Kort>{
	
	private LinkedList<Kort> kortstokk;
	
	public KortStokk() {
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
	//B)
	@Override
	public Iterator<Kort> iterator() {
		return kortstokk.iterator();
	}
	public void skrivUt() {
		int antall = 0;
		for (Kort kort : this) {
			System.out.print(kort + " ");
			antall++;
			if(antall == 10) {
				System.out.println();
				antall = 0;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		KortStokk stokk = new KortStokk();
		
		System.out.println("Ustokket kortstokk: "); 
		stokk.skrivUt();
		
		System.out.println("\n\nStokker kortstokken... ");
		stokk.Shuffle();
		
		System.out.println("Stokket kortstokk: ");
		stokk.skrivUt();
		
		System.out.println("\n\nTrekt kort: ");
		System.out.println(stokk.trekkKort());
		
		
	}
}
