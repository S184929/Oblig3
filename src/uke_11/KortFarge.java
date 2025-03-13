package uke_11;

public enum KortFarge {
	LOEVER("♣"), RUTER("♢"), SPAR("♠"), HJERTER("♡");
	private String symbol;
	KortFarge(String symbol) {
		this.symbol = symbol;
	}
	public String getKortsymbol() {
		return symbol;
	}
	@Override
	public String toString() {
		return symbol;
	}
	
}
