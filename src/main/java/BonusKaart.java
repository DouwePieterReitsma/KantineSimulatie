public class BonusKaart implements KortingskaartHouder {

    @Override
    public double geefKortingsPercentage() {
        return 0.20;
    }

    @Override
    public boolean heeftMaximum() {
        return true;
    }

    @Override
    public double geefMaximum() {
        return 1;
    }
}
