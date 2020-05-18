public class KantineMedewerker extends Persoon {
    private int medewerkersnummer;
    private boolean magAchterDeKassaStaan;

    public KantineMedewerker() {

    }

    public KantineMedewerker(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int medewerkersnummer, boolean magAchterDeKassaStaan) {
        super(BSN, voornaam, achternaam, geboorteDatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magAchterDeKassaStaan = magAchterDeKassaStaan;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isMagAchterDeKassaStaan() {
        return magAchterDeKassaStaan;
    }

    public void setMagAchterDeKassaStaan(boolean magAchterDeKassaStaan) {
        this.magAchterDeKassaStaan = magAchterDeKassaStaan;
    }

    @Override
    public String toString() {
        return "KantineMedewerker{" +
                "medewerkersnummer=" + medewerkersnummer +
                ", magAchterDeKassaStaan=" + magAchterDeKassaStaan +
                '}';
    }
}
