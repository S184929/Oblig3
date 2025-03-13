package uke_10;

public class MatchMain {
    public static int match(Person a, Person b) {
        LenketMengde<String> hobbyerA = a.getHobbyer();
        LenketMengde<String> hobbyerB = b.getHobbyer();
        
        MengdeADT<String> fellesHobbyer = hobbyerA.snitt(hobbyerB);
        int antallFelles = fellesHobbyer.antallElementer();
        
        MengdeADT<String> kunHosA = hobbyerA.minus(hobbyerB);
        MengdeADT<String> kunHosB = hobbyerB.minus(hobbyerA);
        
        int antallKunHosDenEne = kunHosA.antallElementer();
        int antallKunHosDenAndre = kunHosB.antallElementer();
        
        int antallTotalt = hobbyerA.antallElementer() + hobbyerB.antallElementer() - antallFelles;

        return (int) antallFelles - ((antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt);
        
    }
    

    public static void main(String[] args) {

        Person Erik = new Person("Erik", "fotball", "geoguessr", "venner", "data");
        Person Felix = new Person("Felix", "fotball", "gaming", "tur", "musikk", "geoguessr");
        Person Brede = new Person("Brede", "anime", "soving", "fotball", "film");
        Person Sigurd = new Person("Sigurd", "biljard", "anime", "gaming", "slalom");

        LenketMengde<String> matchResultater = new LenketMengde<>();

        int matchErikFelix = match(Erik, Felix);
        matchResultater.leggTil("Match mellom Erik og Felix: " + (matchErikFelix < 0 ? 0 : matchErikFelix));

        int matchErikSigurd = match(Erik, Sigurd);
        matchResultater.leggTil("Match mellom Erik og Sigurd: " + (matchErikSigurd < 0 ? 0 : matchErikSigurd));

        int matchBredeFelix = match(Brede, Felix);
        matchResultater.leggTil("Match mellom Brede og Felix: " + (matchBredeFelix < 0 ? 0 : matchBredeFelix));
        
        int matchErikBrede = match(Erik, Brede);
        matchResultater.leggTil("Match mellom Erik og Brede: " + (matchErikBrede < 0 ? 0 : matchErikBrede));

        Object[] resultaterObject = matchResultater.tilTabell();

        String[] resultater = new String[resultaterObject.length];
        for (int i = 0; i < resultaterObject.length; i++) {
        	resultater[i] = (String) resultaterObject[i];
        }
        for (int i = 0; i < resultater.length; i++) {
            System.out.println(resultater[i]);
        }
    }
}
