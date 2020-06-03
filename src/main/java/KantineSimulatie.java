import java.util.*;

import javax.persistence.*;

public class KantineSimulatie {
    private static final int DAGEN = 7;
    private static final int AANTAL_STUDENTEN = 89;
    private static final int AANTAL_DOCENTEN = 10;
    private static final int AANTAL_KANTINEMEDEWERKERS = 1;

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
//    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
//    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    // JPA
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("KantineSimulatie");

    private EntityManager manager;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();

        kantine = new Kantine(manager);

        random = new Random();
        int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];
        }

        return artikelen;
    }

    private void printTotaleOmzetEnKorting() {
        try {
            Query query = manager.createNativeQuery("SELECT SUM(totaal), SUM(korting) FROM factuur;");

            Object[] result = (Object[]) query.getSingleResult();

            System.out.println("Totale omzet: " + result[0]);
            System.out.println("Totaal gegeven korting: " + result[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printGemiddeldeOmzetEnKortingPerFactuur() {
        try {
            Query query = manager.createNativeQuery("SELECT AVG(totaal), AVG(korting) FROM factuur;");

            Object[] result = (Object[]) query.getSingleResult();

            System.out.println("Gemiddelde omzet per factuur: " + result[0]);
            System.out.println("Gemiddeld gegeven korting per factuur: " + result[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printTop3Facturen() {
        try {
            Query query = manager.createNativeQuery("SELECT * FROM factuur ORDER BY totaal DESC LIMIT 3", Factuur.class);

            List<Factuur> top3 = query.getResultList();

            int i = 1;

            System.out.println("Top 3 facturen:");
            System.out.println();

            for(Factuur factuur : top3) {
                System.out.println(i++ + ": " + factuur.toString());
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Week 3 versie
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        int[] verkochteArtikelenPerDag = new int[dagen];
        double[] omzetPerDag = new double[dagen];

        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            ArrayList<Persoon> klanten = new ArrayList<>();

            int aantalPersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            for(int j = 0; j < aantalPersonen; j++) {
                int r = getRandomValue(1, AANTAL_STUDENTEN + AANTAL_STUDENTEN + AANTAL_DOCENTEN);

                if (r <= AANTAL_KANTINEMEDEWERKERS) {
                    klanten.add(new KantineMedewerker());
                } else if(r <= AANTAL_STUDENTEN + AANTAL_KANTINEMEDEWERKERS) {
                    klanten.add(new Student());
                } else if(r <= AANTAL_DOCENTEN + AANTAL_STUDENTEN + AANTAL_KANTINEMEDEWERKERS) {
                    klanten.add(new Docent());
                }
            }

            // laat de personen maar komen...
            for (Persoon klant : klanten) {
                // maak een dienblad aan voor de klant
                Dienblad dienblad = new Dienblad(klant);

                Pinpas pinpas = new Pinpas();
                pinpas.setSaldo(1000);
                pinpas.setKredietLimiet(500);

                klant.setBetaalwijze(pinpas);

                //System.out.println(klant.toString());

                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan

                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            verkochteArtikelenPerDag[i] = kantine.getKassa().aantalArtikelen();
            omzetPerDag[i] = kantine.getKassa().hoeveelheidGeldInKassa();


            // druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            System.out.println("Dag " + (i+1));
            System.out.println("Aantal personen: " + klanten.size());
            System.out.println("Aantal artikelen: " + verkochteArtikelenPerDag[i]);
            System.out.println("Hoeveelheid geld: " + omzetPerDag[i]);
            System.out.println();

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }

        double[] dagTotalen = Administratie.berekenDagOmzet(omzetPerDag);

        System.out.println("Simulatie afgelopen");
        System.out.println("----------------------------------");
        System.out.println("Totale omzet op maandagen: " + dagTotalen[0]);
        System.out.println("Totale omzet op dinsdagen: " + dagTotalen[1]);
        System.out.println("Totale omzet op woensdagen: " + dagTotalen[2]);
        System.out.println("Totale omzet op donderdagen: " + dagTotalen[3]);
        System.out.println("Totale omzet op vrijdagen: " + dagTotalen[4]);
        System.out.println("Totale omzet op zaterdagen: " + dagTotalen[5]);
        System.out.println("Totale omzet op zondagen: " + dagTotalen[6]);

        System.out.println("----------------------------------");
        printTotaleOmzetEnKorting();
        System.out.println("Gemiddeld aantal verkochte artikelen: " + Administratie.berekenGemiddeldAantal(verkochteArtikelenPerDag));
        //System.out.println("Gemiddelde omzet: " + Administratie.berekenGemiddeldeOmzet(omzetPerDag));
        printGemiddeldeOmzetEnKortingPerFactuur();

        System.out.println("----------------------------------");
        printTop3Facturen();

        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        KantineSimulatie simulatie = new KantineSimulatie();

        simulatie.simuleer(dagen);
    }
}
