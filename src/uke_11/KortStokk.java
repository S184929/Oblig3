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
	
	public KortStokk(int antall) {
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
		for (Kort kort : this) {
			System.out.println(kort);
		}
	}
	
	public static void main(String[] args) {
		
		KortStokk stokk = new KortStokk(52);
		
		System.out.println("Ustokket kortstokk: "); 
		stokk.skrivUt();
		
		System.out.println("\nStokker kortstokken: ");
		stokk.Shuffle();
		
		System.out.println("\nStokket kortstokk: ");
		stokk.skrivUt();
		
		System.out.println("\nTrekket kort: ");
		System.out.println(stokk.trekkKort());
		
		
	}
}
