package uke_10;

public class LenketMengde<T> implements MengdeADT<T> {
    
    public static class Node<T> {
        T element;
        Node<T> neste;

        public Node(T element) {
            this.element = element;
            this.neste = null;
        }
    }

    Node<T> forste; 
    private int antall;

    public LenketMengde() {
        forste = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return forste == null;  
    }

    @Override
    public boolean inneholder(T element) {
        Node<T> p = forste;  
        while (p != null) {
            if (p.element.equals(element)) {
                return true;
            }
            p = p.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node<T> p = forste; 
        while (p != null) {
            if (!annenMengde.inneholder(p.element)) {
                return false;  
            }
            p = p.neste;
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
        Node<T> p = forste; 

        while (p != null) {
            if (annenMengde.inneholder(p.element)) {
                return false;
            }
            p = p.neste;
        }
        return true;  
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();
        Node<T> p = forste; 

        while (p != null) {
            if (annenMengde.inneholder(p.element)) {
                resultat.leggTil(p.element);
            }
            p = p.neste;
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();
        Node<T> p = forste;  

        while (p != null) {
            resultat.leggTil(p.element);
            p = p.neste;
        }

        Node<T> k = ((LenketMengde<T>) annenMengde).forste;  
        while (k != null) {
            if (!resultat.inneholder(k.element)) {
                resultat.leggTil(k.element);
            }
            k = k.neste;
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();
        Node<T> p = forste;  

        while (p != null) {
            if (!annenMengde.inneholder(p.element)) {
                resultat.leggTil(p.element);
            }
            p = p.neste;
        }
        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            Node<T> ny = new Node<>(element);
            ny.neste = forste; 
            forste = ny; 
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        Node<T> p = ((LenketMengde<T>) annenMengde).forste;  

        while (p != null) {
            leggTil(p.element);
            p = p.neste;
        }
    }

    @Override
    public T fjern(T element) {
        Node<T> forrige = null;
        Node<T> p = forste; 

        while (p != null) {
            if (p.element.equals(element)) {
                if (forrige == null) {  
                    forste = p.neste;  
                } else {
                    forrige.neste = p.neste; 
                }
                antall--;
                return p.element;
            }
            forrige = p;
            p = p.neste;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {   //går fra lenketliste til en arrayliste
        @SuppressWarnings("unchecked")
        T[] tabell = (T[]) new Object[antall];
        Node<T> p = forste; 
        int index = 0;

        while (p != null) {
            tabell[index] = p.element;
            p = p.neste;
            index++;
        }

        return tabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
