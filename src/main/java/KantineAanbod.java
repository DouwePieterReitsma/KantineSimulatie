import org.hibernate.Transaction;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

public class KantineAanbod {
    private EntityManager manager;

    /**
     * Constructor. Het tweede argument is een lijst met artikelnamen, het derde argument is
     * eenlijst met prijzen en het vierde argument is een lijst met hoeveelheden. Let op: de
     * dimensies van de drie arrays moeten wel gelijk zijn!
     */

    public KantineAanbod(EntityManager manager, String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        this.manager = manager;

        Random random = new Random();

        for (int i = 0; i < artikelnaam.length; i++) {
            Artikel artikel = null;

            // er moet tenminste één artikel in de aanbieding zijn.
            boolean heeftKorting = i == 0 || random.nextBoolean();

            if (heeftKorting) {
                artikel = new Artikel(artikelnaam[i], prijs[i], prijs[i] * 0.2);
            } else {
                artikel = new Artikel(artikelnaam[i], prijs[i]);
            }

            Voorraad voorraad = new Voorraad(artikel, hoeveelheid[i], 4);

            manager.getTransaction().begin();
            manager.persist(voorraad);
            manager.getTransaction().commit();
        }
    }

    /**
     * Private methode om de voorraad van de kantine aan te vullen
     * @param productnaam
     */
//    private void vulVoorraadAan(String productnaam) {
////        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
////        int startHoeveelheid = startVoorraad.get(productnaam);
////        int huidigeHoeveelheid = huidigeVoorraad.size();
////        double prijs = prijzen.get(productnaam);
////
////        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
////            huidigeVoorraad.add(new Artikel(productnaam, prijs));
////        }
////
////        aanbod.put(productnaam, huidigeVoorraad);
//        Voorraad v = vraagVoorraadOp(productnaam);
//
//        if (v != null) {
//            v.setVoorraad(v.getStartvoorraad());
//
//            manager.persist(v);
//        }
//    }


    private void vulVoorraadAan(Voorraad voorraad) {
        System.out.println("Voorraad wordt aangevuld! Artikel: " + voorraad.getArtikel().getNaam());

        voorraad.setVoorraad(voorraad.getStartvoorraad());

        manager.persist(voorraad);
    }

    private Voorraad vraagVoorraadOp(String productnaam) {
        try {
            return (Voorraad) manager.createQuery("SELECT v FROM Voorraad v WHERE v.artikel.naam = :productnaam")
                    .setParameter("productnaam", productnaam)
                    .getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
//    private ArrayList<Artikel> getArrayList(String productnaam) {
//        return aanbod.get(productnaam);
//    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
//    private Artikel getArtikel(ArrayList<Artikel> stapel) {
//        if (stapel == null) {
//            return null;
//        }
//        if (stapel.size() == 0) {
//            return null;
//        } else {
//            Artikel a = stapel.get(0);
//            stapel.remove(0);
//            if (stapel.size() <= 10)
//                vulVoorraadAan(a.getNaam());
//            return a;
//        }
//    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productnaam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {
        //return getArtikel(getArrayList(productnaam));

        Voorraad v = vraagVoorraadOp(productnaam);

        if (v == null) return null;

        if (v.getVoorraad() == 0) return null;

        v.setVoorraad(v.getVoorraad() - 1);

        manager.getTransaction().begin();

        if (v.getVoorraad() <= v.getKantelpunt()) {
            vulVoorraadAan(v);
        } else {
            manager.persist(v);
        }

        manager.getTransaction().commit();

        return v.getArtikel();
    }
}
