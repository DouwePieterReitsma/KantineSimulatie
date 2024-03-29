import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

public abstract class Betaalwijze {

    protected double saldo;

    /**
     * Methode om krediet te initialiseren
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     * @throws TeWeinigGeldException
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;
}
