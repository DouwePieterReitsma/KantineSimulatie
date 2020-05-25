public class Persoon {
    private String BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboorteDatum;
    private char geslacht;

    private Betaalwijze betaalwijze;

    /**
     * default constructor
     */
    public Persoon() {
        this.geboorteDatum = null;
        this.geslacht = 'O';
    }

    /**
     * Specifieke constructor
     * @param BSN
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     */
    public Persoon(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboorteDatum = geboorteDatum;
        setGeslacht(geslacht);
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboorteDatum() {
        if (geboorteDatum == null) return "Onbekend";

        return geboorteDatum.getDatumAsString();
    }

    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeslacht() {
        if (geslacht == 'M') {
            return "Man";
        } else if (geslacht == 'V') {
            return "Vrouw";
        } else {
            return "Onbekend";
        }
    }

    /**
     * setter voor geslacht
     * @param geslacht alleen M en V zijn geldige waarden.
     */
    public void setGeslacht(char geslacht) {
        // check of geslacht 'M' of 'V' is, als dit niet zo is wordt er de 'O' van onbekend neergezet.
        this.geslacht = (geslacht == 'M' || geslacht == 'V') ? geslacht : 'O';
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "BSN='" + getBSN() + '\'' +
                ", voornaam='" + getVoornaam() + '\'' +
                ", achternaam='" + getAchternaam() + '\'' +
                ", geboorteDatum=" + getGeboorteDatum() +
                ", geslacht=" + getGeslacht() +
                '}';
    }
}