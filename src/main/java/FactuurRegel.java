import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "factuurregel")
public class FactuurRegel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factuur_id")
    private Factuur factuur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artikel", referencedColumnName = "naam")
    private Artikel artikel;

    // dit lijkt dubbelop, maar ik doe dit om te voorkomen dat de prijs en korting van het artikel wordt overschreven in de database.
    private double korting;
    private double prijs;

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;

        this.korting = artikel.getKorting();
        this.prijs = artikel.getPrijs();
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return String.format("%-15.15s       %.2f       %.2f", artikel.getNaam(), korting, prijs);
    }
}
