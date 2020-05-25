public class KantineMedewerker extends Persoon implements KortingskaartHouder {
    private int medewerkersnummer;
    private boolean magAchterDeKassaStaan;

    /**
     * Constructor
     */
    public KantineMedewerker() {

    }

    /**
     * Constructor
     * @param BSN
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     * @param medewerkersnummer
     * @param magAchterDeKassaStaan
     */
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

    @Override
    public double geefKortingsPercentage() {
        return 35;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return 0;
    }
}
