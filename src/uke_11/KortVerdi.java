package uke_11;

public enum KortVerdi {
	TO(2), TRE(3), FIRE(4), FEM(5), SEKS(6), SYV(7), AATTE(8), NI(9), TI(10),
	KNEKT(11, "J"), DAME(12, "Q"), KONGE(13, "K"), ESS(14, "A");
	private int kortverdi;
	private String navn;
	
	private KortVerdi(int verdi) {
		this.kortverdi = verdi;
		this.navn = "" + verdi;
	}
	private KortVerdi(int verdi, String navn) {
		this.kortverdi = verdi;
		this.navn = navn;
	}
	public int getKortverdi() {
		return kortverdi;
	}
	public String getKortverdiNavn() {
		return navn;
	}
	@Override
	public String toString() {
		return navn;
	}
}
