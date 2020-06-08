import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class KantineMedewerker extends Persoon implements KortingskaartHouder {
    @Column(name = "medewerkersnummer")
    private int medewerkersnummer;

    @Column(name = "kassabevoegdheid")
    private boolean kassabevoegdheid;

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
    public KantineMedewerker(String BSN, String voornaam, String achternaam, LocalDate geboorteDatum, char geslacht, int medewerkersnummer, boolean magAchterDeKassaStaan) {
        super(BSN, voornaam, achternaam, geboorteDatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.kassabevoegdheid = magAchterDeKassaStaan;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isKassabevoegdheid() {
        return kassabevoegdheid;
    }

    public void setKassabevoegdheid(boolean kassabevoegdheid) {
        this.kassabevoegdheid = kassabevoegdheid;
    }

    @Override
    public String toString() {
        return "KantineMedewerker{" +
                "medewerkersnummer=" + medewerkersnummer +
                ", kassabevoegdheid=" + kassabevoegdheid +
                '}';
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.35;
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
