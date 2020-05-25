public class Docent extends Persoon implements KortingskaartHouder {
    private String afkorting;
    private String afdeling;

    /**
     * Constructor
     */
    public Docent() {

    }

    /**
     * Constructor
     * @param BSN
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     * @param afkorting String van 4 letters
     * @param afdeling
     */
    public Docent(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String afkorting, String afdeling) {
        super(BSN, voornaam, achternaam, geboorteDatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        return "Docent{" +
                "afkorting='" + afkorting + '\'' +
                ", afdeling='" + afdeling + '\'' +
                '}';
    }

    @Override
    public double geefKortingsPercentage() {
        return 25.0;
    }

    @Override
    public boolean heeftMaximum() {
        return true;
    }

    @Override
    public double geefMaximum() {
        return 1.0;
    }
}
