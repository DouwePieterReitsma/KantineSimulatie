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
    public void betaal(double tebetalen) throws TeWeinigGeldException{
        if (tebetalen > kredietlimiet) throw new TeWeinigGeldException("Bedrag zit over kredietlimiet heen"); // je mag niet meer dan het kredietlimiet betalen

        double nieuwSaldo = saldo - tebetalen;

        if (nieuwSaldo < 0) throw new TeWeinigGeldException("Te weinig saldo");

        setSaldo(nieuwSaldo);
    }
}
