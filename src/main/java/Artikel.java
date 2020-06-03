import java.math.BigDecimal;

import javax.persistence.*;


/*
* week 1: opgave 1
*
* Declaratie is het opstellen van een variabele. Initialisatie is het geven van een waarde aan een variabele.
*
* */

@Embeddable
public class Artikel {
    @Column(name = "artikel")
    private String naam;

    @Column(name = "prijs")
    private double prijs;

    @Column(name = "korting")
    private double korting;

    /**
     * Constructor
     */
    public Artikel() {
        this.naam = "undefined";
        this.prijs = 0;
        this.korting = 0;
    }

    /**
     * Constructor
     * @param naam
     * @param prijs
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = 0;
    }

    public Artikel(String naam, double prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + getNaam() + '\'' +
                ", prijs=" + getPrijs() +
                '}';
    }
}