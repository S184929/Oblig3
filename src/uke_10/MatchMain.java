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

        Person Erik = new Person("Erik", "fotball", "geoguessr", "venner", "film", "slalom", "biljard");
        Person Felix = new Person("Felix", "fotball", "gaming", "tur", "musikk", "amime", "geoguessr");
        Person Brede = new Person("Brede", "anime", "soving", "fotball", "film");
        Person Sigurd = new Person("Sigurd", "biljard", "anime", "gaming", "slalom");

        LenketMengde<String> matchResultater = new LenketMengde<>();

        int matchErikFelix = match(Erik, Felix);
        matchResultater.leggTil("Erik og Felix: " + (matchErikFelix < 0 ? 0 : matchErikFelix));

        int matchErikSigurd = match(Erik, Sigurd);
        matchResultater.leggTil("Erik og Sigurd: " + (matchErikSigurd < 0 ? 0 : matchErikSigurd));

        int matchBredeFelix = match(Brede, Felix);
        matchResultater.leggTil("Brede og Felix: " + (matchBredeFelix < 0 ? 0 : matchBredeFelix));

        int matchErikBrede = match(Erik, Brede);
        matchResultater.leggTil("Erik og Brede: " + (matchErikBrede < 0 ? 0 : matchErikBrede));

        int matchSigurdBrede = match(Sigurd, Brede);
        matchResultater.leggTil("Sigurd og Brede: " + (matchSigurdBrede < 0 ? 0 : matchSigurdBrede));
        
        String bestMatch = finnBesteMatch(matchResultater);

        Object[] resultaterObject = matchResultater.tilTabell();
        for (Object resultat : resultaterObject) {
            System.out.println(resultat);
        }

        System.out.println("Den beste matchen er: " + bestMatch);
    }
    
    public static String finnBesteMatch(LenketMengde<String> resultater) {
        StringBuilder bestMatches = new StringBuilder();
        int maxScore = -1;
        
        Object[] resultaterArray = resultater.tilTabell();

        for (int i = 0; i < resultaterArray.length; i++) {
            String resultat = (String) resultaterArray[i];
          
            String[] parts = resultat.split(": ");
            if (parts.length == 2) {
                try {
                    int score = Integer.parseInt(parts[1]); 
                    if (score > maxScore) { 
                        maxScore = score;
                        bestMatches.setLength(0); 
                        bestMatches.append(parts[0]);
                    } else if (score == maxScore) {
                        bestMatches.append(", ").append(parts[0]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Feil i poeng: " + parts[1]);
                }
            }
        }

        return bestMatches.toString();
    }


}
