import net.bytebuddy.asm.Advice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Iterator;

public class Kassa {
    private int artikelen;
    private double geld;
    private double toegepasteKorting;
    private KassaRij kassaRij;
    private LocalDate datum;

    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        this.artikelen = 0;
        this.geld = 0;
        this.toegepasteKorting = 0;
        this.kassaRij = kassarij;
        this.datum = LocalDate.ofYearDay(2020, 1);

        this.manager = manager;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        //Persoon persoon = klant.getKlant();
//        int artikelenOpDienblad = 0;
//        double totaalPrijs = 0;
//        double medewerkerskorting = 0;
//        boolean heeftMaximum = false;
//        double maxKorting = 0;
//
//        if (persoon instanceof Docent) {
//            Docent docent = (Docent)persoon;
//
//            medewerkerskorting = docent.geefKortingsPercentage();
//            heeftMaximum = docent.heeftMaximum();
//            maxKorting = docent.geefMaximum();
//
//        } else if(persoon instanceof KantineMedewerker) {
//            KantineMedewerker kantineMedewerker = (KantineMedewerker)persoon;
//
//            medewerkerskorting = kantineMedewerker.geefKortingsPercentage();
//            heeftMaximum = kantineMedewerker.heeftMaximum();
//            maxKorting = kantineMedewerker.geefMaximum();
//        }
//
//        Iterator<Artikel> iterator = klant.getArtikelenIterator();
//
//        while(iterator.hasNext()) {
//            Artikel artikel = iterator.next();
//
//            artikelenOpDienblad++;
//
//            double prijs = artikel.getPrijs();
//            double teBetalen = 0;
//            double korting = artikel.getKorting();
//
//            // als het artikel in de aanbieding is geld de medewerkerskorting niet.
//            if (korting > 0) {
//                teBetalen = prijs - korting;
//            } else {
//                korting = 1 - medewerkerskorting;
//
//                teBetalen = prijs * korting;
//
//                if (heeftMaximum) {
//                    if (prijs - teBetalen > maxKorting) {
//                        teBetalen = prijs - maxKorting;
//                    }
//                }
//            }
//
//            totaalPrijs += teBetalen;
//        }

        Persoon persoon = klant.getKlant();
        Factuur factuur = new Factuur(klant, this.datum);

        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();

            transaction.begin();

            persoon.getBetaalwijze().betaal(factuur.getTotaal());

            this.artikelen += klant.aantalArtikelen();
            this.geld += factuur.getTotaal();
            this.toegepasteKorting += factuur.getKorting();

            manager.persist(factuur);
            transaction.commit();

            System.out.println(factuur.toString());
            System.out.println();

        } catch(TeWeinigGeldException e) {
            System.out.println("Betaling mislukt voor persoon: " + persoon.toString());
            System.out.println("Reden: " + e.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }

        kassaRij.verlaatRij(klant);
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return artikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geld;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        artikelen = 0;
        geld = 0;

        // increment de dag als de kassa gereset wordt.
        this.datum = datum.plusDays(1);
    }
}
