package uke_11;

import uke_11.KortFarge;
import uke_11.KortVerdi;

public record Kort(KortFarge farge, KortVerdi verdi) {	
	@Override
	public String toString() {
		return "[" + farge + " "+ verdi + "]";
	}
}
