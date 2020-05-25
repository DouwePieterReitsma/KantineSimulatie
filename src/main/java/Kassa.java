import java.util.Iterator;

public class Kassa {
    private int artikelen;
    private double geld;
    private KassaRij kassaRij;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.artikelen = 0;
        this.geld = 0;
        this.kassaRij = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Persoon persoon = klant.getKlant();
        int artikelenOpDienblad = 0;
        double totaalPrijs = 0;
        double korting = 0;
        boolean heeftMaximum = false;
        double maxKorting = 0;

        Iterator<Artikel> iterator = klant.getArtikelenIterator();

        while(iterator.hasNext()) {
            Artikel artikel = iterator.next();

            artikelenOpDienblad++;
            totaalPrijs += artikel.getPrijs();
        }

        if (persoon instanceof Docent) {
            Docent docent = (Docent)persoon;

            korting = docent.geefKortingsPercentage();
            heeftMaximum = docent.heeftMaximum();
            maxKorting = docent.geefMaximum();

        } else if(persoon instanceof KantineMedewerker) {
            KantineMedewerker kantineMedewerker = (KantineMedewerker)persoon;

            korting = kantineMedewerker.geefKortingsPercentage();
            heeftMaximum = kantineMedewerker.heeftMaximum();
            maxKorting = kantineMedewerker.geefMaximum();
        }

        double teBetalen = totaalPrijs * (1 - korting);

        if (heeftMaximum) {
            if (totaalPrijs - teBetalen > maxKorting) {
                teBetalen = totaalPrijs - maxKorting;
            }
        }

        try{
            persoon.getBetaalwijze().betaal(teBetalen);

            this.artikelen += artikelenOpDienblad;
            this.geld += teBetalen;

        } catch(TeWeinigGeldException e) {
            System.out.println("Betaling mislukt voor persoon: " + persoon.toString());
            System.out.println("Reden: " + e.getMessage());
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
    }
}
