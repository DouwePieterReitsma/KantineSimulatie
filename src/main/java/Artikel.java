import java.math.BigDecimal;

/*
* week 1: opgave 1
*
* Declaratie is het opstellen van een variabele. Initialisatie is het geven van een waarde aan een variabele.
*
* */

public class Artikel {
    private String naam;
    private BigDecimal prijs;

    public Artikel() {
        this.naam = "undefined";
        this.prijs = BigDecimal.valueOf(0);
    }

    public Artikel(String naam, BigDecimal prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + getNaam() + '\'' +
                ", prijs=" + getPrijs().toString() +
                '}';
    }
}