import java.math.BigDecimal;

/*
* week 1: opgave 1
*
* Declaratie is het opstellen van een variabele. Initialisatie is het geven van een waarde aan een variabele.
*
* */

public class Artikel {
    private String naam;
    private double prijs;

    /**
     * Constructor
     */
    public Artikel() {
        this.naam = "undefined";
        this.prijs = 0;
    }

    /**
     * Constructor
     * @param naam
     * @param prijs
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
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

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + getNaam() + '\'' +
                ", prijs=" + getPrijs() +
                '}';
    }
}