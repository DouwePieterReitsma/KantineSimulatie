import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "factuur")
public class Factuur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum")
    private LocalDate datum;

    @Column(name = "korting")
    private double korting;

    @Column(name = "totaal")
    private double totaal;

    @OneToMany(targetEntity = FactuurRegel.class, mappedBy = "factuur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactuurRegel> regels;

    public Factuur() {
        totaal = 0;
        korting = 0;

        regels = new ArrayList<>();
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe.
     *
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {
        Persoon persoon = klant.getKlant();
        double medewerkerskorting = 0;
        boolean heeftMaximum = false;
        double maxKorting = 0;
        double totaalZonderKorting = 0;

        if (persoon instanceof Docent) {
            Docent docent = (Docent)persoon;

            medewerkerskorting = docent.geefKortingsPercentage();
            heeftMaximum = docent.heeftMaximum();
            maxKorting = docent.geefMaximum();

        } else if(persoon instanceof KantineMedewerker) {
            KantineMedewerker kantineMedewerker = (KantineMedewerker)persoon;

            medewerkerskorting = kantineMedewerker.geefKortingsPercentage();
            heeftMaximum = kantineMedewerker.heeftMaximum();
            maxKorting = kantineMedewerker.geefMaximum();
        }

        Iterator<Artikel> iterator = klant.getArtikelenIterator();

        while(iterator.hasNext()) {
            Artikel artikel = iterator.next();

            double artikelPrijs = artikel.getPrijs();
            double teBetalen = 0;
            double artikelKorting = artikel.getKorting();

            // als het artikel in de aanbieding is geld de medewerkerskorting niet.
            if (artikelKorting > 0) {
                teBetalen = artikelPrijs - artikelKorting;
            } else {
                artikelKorting = 1 - medewerkerskorting;

                teBetalen = artikelPrijs * artikelKorting;

                if (heeftMaximum) {
                    if (artikelPrijs - teBetalen > maxKorting) {
                        teBetalen = artikelPrijs - maxKorting;
                    }
                }
            }

            totaal += teBetalen;
            totaalZonderKorting += artikelPrijs;

            regels.add(new FactuurRegel(this, artikel));
        }

        korting = totaalZonderKorting - totaal;
    }

    /*
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting als een getal (geen percentage)
     */
    public double getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Factuur #%d %s", id, datum.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        builder.append("\r\n\r\n-------------------------------------\r\n\r\n");

        builder.append(String.format("%-15.15s %10s %10s\r\n", "Artikel", "Korting", "Prijs"));
        builder.append(String.format("%-15.15s %10s %10s\r\n\r\n", "-------", "-------", "-----"));

        for(FactuurRegel regel : regels) {
            builder.append(regel.toString());
            builder.append("\r\n");
        }

        builder.append(String.format("%-15.15s %10s %10s\r\n\r\n", "-------", "-------", "-----"));

        builder.append(String.format("%-15.15s %10.2f %10.2f", "Totaal:", getKorting(), getTotaal()));

        return builder.toString();
    }

}
