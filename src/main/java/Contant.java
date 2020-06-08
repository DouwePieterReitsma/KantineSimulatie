import javax.persistence.Entity;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        double nieuwSaldo = saldo - tebetalen;

        if (nieuwSaldo < 0) throw new TeWeinigGeldException("Te weinig saldo");

        setSaldo(nieuwSaldo);
    }
}
