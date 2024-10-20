package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KonwersjaJednostekTest {

    KonwersjaJednostek konwersjaJednostek;

    @BeforeEach
    void setUp() {
        konwersjaJednostek = new KonwersjaJednostek();
    }

    @Test
    @DisplayName("Kg na funty")
    void kgToPoundTest() {
        assertEquals(0, konwersjaJednostek.kgToPound(0), 0.00001);
        assertEquals(2.20462, konwersjaJednostek.kgToPound(1), 0.00001);
        assertEquals(22.266662, konwersjaJednostek.kgToPound(10.1), 0.00001);
    }

    @Test
    @DisplayName("Mile na kilometry")
    void mileToKmTest() {
        assertEquals(0, konwersjaJednostek.mileToKm(0), 0.00001);
        assertEquals(1.609344, konwersjaJednostek.mileToKm(1), 0.00001);
        assertEquals(16.2543744, konwersjaJednostek.mileToKm(10.1), 0.00001);
    }

    @Test
    @DisplayName("Litry na galony")
    void literToGallonTest() {
        assertEquals(0, konwersjaJednostek.literToGallon(0), 0.00001);
        assertEquals(0.2641720524, konwersjaJednostek.literToGallon(1), 0.00001);
        assertEquals(2.66813772924, konwersjaJednostek.literToGallon(10.1), 0.00001);
    }

    @Test
    @DisplayName("Litry na uncje imperialne")
    void literToOunceTest() {
        assertEquals(0, konwersjaJednostek.literToOunce(0), 0.00001);
        assertEquals(35.19508, konwersjaJednostek.literToOunce(1), 0.00001);
        assertEquals(355.470308, konwersjaJednostek.literToOunce(10.1), 0.00001);
    }

    @Test
    @DisplayName("Litry na pinty imperialne")
    void literToPintTest() {
        assertEquals(0, konwersjaJednostek.literToPint(0), 0.00001);
        assertEquals(1.759754, konwersjaJednostek.literToPint(1), 0.00001);
        assertEquals(17.7735154, konwersjaJednostek.literToPint(10.1), 0.00001);
    }
}