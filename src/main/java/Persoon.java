import com.sun.istack.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name="persoon")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Persoon {
    @Id
    @Column(name = "BSN")
    private String BSN;

    @Column(name = "voornaam")
    private String voornaam;

    @Column(name = "achternaam")
    private String achternaam;

    @Column(name = "geboortedatum")
    private LocalDate geboortedatum;

    @Column(name = "geslacht")
    private char geslacht;

    @Column(name = "heeftBonuskaart")
    private boolean heeftBonuskaart;

    @Transient
    private Betaalwijze betaalwijze;

    /**
     * default constructor
     */
    public Persoon() {
        this.geboortedatum = null;
        this.geslacht = 'O';

        this.BSN = genereerRandomBSN();
    }

    /**
     * Specifieke constructor
     * @param BSN
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     */
    public Persoon(String BSN, String voornaam, String achternaam, LocalDate geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboorteDatum;
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

    public String getGeboortedatum() {
        return geboortedatum == null ? "Onbekend" : geboortedatum.toString();
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
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

    private String genereerRandomBSN() {
        Random random = new Random();

        return "bsn" + random.nextInt();
    }

    public boolean heeftBonuskaart() {
        return heeftBonuskaart;
    }

    public void setHeeftBonuskaart(boolean heeftBonuskaart) {
        this.heeftBonuskaart = heeftBonuskaart;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "BSN='" + getBSN() + '\'' +
                ", voornaam='" + getVoornaam() + '\'' +
                ", achternaam='" + getAchternaam() + '\'' +
                ", geboortedatum=" + getGeboortedatum() +
                ", geslacht=" + getGeslacht() +
                '}';
    }
}