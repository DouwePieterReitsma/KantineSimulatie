import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DatumTest {
    @Test
    public void datumBestaat() {
        Datum datum = new Datum();

        assertEquals(true, datum.bestaatDatum(31, 3, 2000), "31 maart 2000 moet een geldige datum zijn.");
        assertEquals(true, datum.bestaatDatum(14, 5, 2020), "14 mei 2020 moet een geldige datum zijn.");

    }

    @Test
    public void datumBestaatNiet() {
        Datum datum = new Datum();

        assertEquals(false, datum.bestaatDatum(34, 1, 1987), "34 januari 1987 moet geen geldige datum zijn.");
        assertEquals(false, datum.bestaatDatum(31, 4, 1987), "31 april 2002 moet geen geldige datum zijn.");
    }
}
