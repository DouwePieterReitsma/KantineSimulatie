public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan() {
        // method body omitted
        Persoon persoon = new Persoon();
        Dienblad dienblad = new Dienblad(persoon);

        dienblad.voegToe(new Artikel("Broodje", 3.50));
        dienblad.voegToe(new Artikel("Cola", 2.50));

        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        // week 2: opdracht 1a:
        // het is hier handiger om een while-loop te gebruiken i.p.v. een for-loop omdat we de functie erIsEenRij gebruiken die true returnt zolang er een rij is.

        while (kassarij.erIsEenRij()) {
            Dienblad klant = kassarij.eerstePersoonInRij();

            kassa.rekenAf(klant);
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
        return kassa.aantalArtikelen();
    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {
        kassa.resetKassa();
    }
}
