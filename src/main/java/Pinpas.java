public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        // method body omitted
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        if (tebetalen > kredietlimiet) return false; // je mag niet meer dan het kredietlimiet betalen

        double nieuwSaldo = saldo - tebetalen;

        if (nieuwSaldo < 0) return false;

        setSaldo(nieuwSaldo);

        return true;
    }
}
