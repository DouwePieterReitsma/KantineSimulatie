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

    public FactuurRegel() {

    }

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    @Override
    public String toString() {
        return String.format("%-15.15s       %.2f       %.2f", artikel.getNaam(), artikel.getKorting(), artikel.getPrijs());
    }
}
