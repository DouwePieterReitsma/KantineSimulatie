public class Administratie {
    private static final int DAGEN_IN_WEEK = 7;

    private Administratie() {

    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        if (aantal.length == 0) return 0; // dit is om te voorkomen dat er door 0 wordt gedeeld.

        double gemiddelde = 0;

        for(int i: aantal) {
            gemiddelde += i;
        }

        gemiddelde = gemiddelde / aantal.length;

        return gemiddelde;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        if (omzet.length == 0) return 0; // dit is om te voorkomen dat er door 0 wordt gedeeld.

        double gemiddelde = 0;

        for(double d : omzet) {
            gemiddelde += d;
        }

        gemiddelde = gemiddelde / omzet.length;

        return gemiddelde;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < DAGEN_IN_WEEK; i++) {

            int j = 0;
            while ((i + 7 * j) < omzet.length ) {
                temp[i] += omzet[i + 7 * j];

                j++;
            }
        }
        return temp;
    }
}
