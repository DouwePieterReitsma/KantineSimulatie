import javax.persistence.*;

@Entity
@Table(name = "voorraad")
public class Voorraad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    private Artikel artikel;

    @Column(name = "voorraad")
    private int voorraad;

    @Column(name = "startvoorraad")
    private int startvoorraad;

    @Column(name = "kantelpunt")
    private int kantelpunt;

    public Voorraad(Artikel artikel, int voorraad, int kantelpunt) {
        this.artikel = artikel;
        this.voorraad = voorraad;
        this.startvoorraad = voorraad;
        this.kantelpunt = kantelpunt;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public int getStartvoorraad() {
        return startvoorraad;
    }

    public void setStartvoorraad(int startvoorraad) {
        this.startvoorraad = startvoorraad;
    }

    public int getKantelpunt() {
        return kantelpunt;
    }

    public void setKantelpunt(int kantelpunt) {
        this.kantelpunt = kantelpunt;
    }
}