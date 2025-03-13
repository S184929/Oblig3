package uke_11;

import java.util.ArrayList;
import java.util.List;
import uke_11.KortFarge;

public class PokerHand {
	private List<Kort> hand;
	private static final int MAX_KORT = 5;
	
	
	public PokerHand(int antall) {
		hand = new ArrayList<>();
	}
		
	public void leggTilKort(Kort kort) {
		if (hand.size() < MAX_KORT) {
			hand.add(kort);
		} else {
			throw new IllegalStateException("Du har 5 kort.");
		}
	}
	public void skrivUt() {
		if (hand.isEmpty()) {
			System.out.println("Pokerhånden er tom. ");
		} else { 
			System.out.println("Pokerhånd: ");
			for (Kort kort : hand) {
				System.out.println(kort);
			}
		}
	}
	public static void main(String[] args) {
		KortStokk stokk = new KortStokk(0);
		stokk.Shuffle();
		
		PokerHand phand = new PokerHand(0);
		for(int i = 0; i < MAX_KORT; i++) {
			phand.leggTilKort(stokk.trekkKort());
		}
		phand.flush();
		
		phand.skrivUt();
	}
	public void flush() {
		if(hand.isEmpty()) {
			throw new IllegalStateException("Hånden er tom.");
		}
		KortFarge farge = hand.get(0).farge();
		for(Kort kort : hand) {
			if(kort.farge() != farge) {
				System.out.println("Du har desverre ikke flush");
				return;
			}
		}
		System.out.println("Du har flush!");
	}
}
