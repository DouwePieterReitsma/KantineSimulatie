import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    //private ArrayList<Artikel> artikelen;
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        klant = null;
        //artikelen = new ArrayList<>();
        artikelen = new Stack<>();
    }

    /**
     * Constructor
     * @param klant
     */
    public Dienblad(Persoon klant) {
        this();

        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

//    /**
//     * Methode om aantal artikelen op dienblad te tellen
//     *
//     * @return Het aantal artikelen
//     */
//    public int getAantalArtikelen() {
//        return artikelen.size();
//    }
//
//    /**
//     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
//     *
//     * @return De totaalprijs
//     */
//    public double getTotaalPrijs() {
//        double totaalprijs = 0;
//
//        for(Artikel artikel : artikelen) {
//            totaalprijs += artikel.getPrijs();
//        }
//
//        return totaalprijs;
//    }

    public Iterator<Artikel> getArtikelenIterator() {
        return artikelen.iterator();
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

