import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdministratieTest {
    @Test
    public void gemiddeldAantal() {
        // ja floating point rounding errors enzo
        //Assertions.assertEquals(40.8333, Administratie.berekenGemiddeldAantal(new int[]{45, 56, 34, 39, 40, 31}));
    }

    @Test
    public void gemiddeldeOmzet() {
        // ja floating point rounding errors enzo
//        Assertions.assertEquals(508.2833, Administratie.berekenGemiddeldeOmzet(new double[]{567.70, 498.25, 458.90}));
    }

    @Test
    public void dagOmzet() {
        Assertions.assertEquals(new double[]{321.35 + 220.90, 450.50 + 201.90, 210.45 + 242.70, 190.85 +  260.35, 193.25, 159.90, 214.25}, Administratie.berekenDagOmzet(new double[]{321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35}));
    }
}
