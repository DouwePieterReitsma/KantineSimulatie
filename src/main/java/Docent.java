import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class Docent extends Persoon implements KortingskaartHouder {
    @Column(name = "afkorting")
    private String afkorting;

    @Column(name = "afdeling")
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
    public Docent(String BSN, String voornaam, String achternaam, LocalDate geboorteDatum, char geslacht, String afkorting, String afdeling) {
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
        return 0.25;
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
