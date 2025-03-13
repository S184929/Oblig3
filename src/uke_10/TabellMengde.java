package uke_10;

public class TabellMengde<T> implements MengdeADT<T>{
	
	private T[] tabell;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tabell = (T[]) new Object[10];
        antall = 0;
    }
    
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (tabell[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
			if (antall != annenMengde.antallElementer()) {
				return false;
			}
		return erDelmengdeAv(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])){
				return false;
				
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> resultat = new TabellMengde<>();
		
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])){
				resultat.leggTil(tabell[i]);
			}
		}
		return resultat;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> resultat = new TabellMengde<>();
		
		for (int i = 0; i < antall; i++) {
			resultat.leggTil(tabell[i]);
		}
		
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
	        if (!resultat.inneholder(annenMengde.tilTabell()[i])) {
	            resultat.leggTil(annenMengde.tilTabell()[i]);
	        }
		}
		return resultat;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> resultat = new TabellMengde<>();
		
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
	            resultat.leggTil(tabell[i]);
	        }
		}
		return resultat;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall < tabell.length) {
				tabell[antall] = element;
				antall++;
			}
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			T element = annenMengde.tilTabell()[i];
            leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
	    for (int i = 0; i < antall; i++) {
	        if (tabell[i].equals(element)) {
	            T fjernetElement = tabell[i];
	            
	            for (int j = i; j < antall - 1; j++) {
	                tabell[j] = tabell[j + 1];
	            }
	            
	            tabell[antall - 1] = null;
	            antall--;
	            return fjernetElement;
	        }
	    }
	    return null;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] nyTabell = (T[]) new Object[antall];
		for (int i = 0; i < antall; i++) {
	        nyTabell[i] = tabell[i];
	    }
	    
	    return nyTabell;
	}

	@Override
	public int antallElementer() {	
		return antall;
	}
}
