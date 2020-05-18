public class Docent extends Persoon {
    private String afkorting;
    private String afdeling;

    public Docent() {

    }

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
}
