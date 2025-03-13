package uke_10;

public class Person {
    private String navn;
    private LenketMengde<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new LenketMengde<>();
        
        for (int i = 0; i < hobbyer.length; i++) {
            this.hobbyer.leggTil(hobbyer[i]);
        }
    }

    public String getNavn() {
        return navn;
    }

    public LenketMengde<String> getHobbyer() {
        return hobbyer;
    }
}

