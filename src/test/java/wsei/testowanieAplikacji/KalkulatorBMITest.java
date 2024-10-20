package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorBMITest {

    KalkulatorBMI kalkulatorBMI;

    @BeforeEach
    void setUp() {
        kalkulatorBMI = new KalkulatorBMI();
    }

    @Test
    @DisplayName("Kalkulator BMI")
    void calcBMI() {
        assertThrows(IllegalArgumentException.class, () -> kalkulatorBMI.calcBMI(1, 0));
        assertThrows(IllegalArgumentException.class, () -> kalkulatorBMI.calcBMI(0, 1));

        assertEquals(1, kalkulatorBMI.calcBMI(1, 1), 0.00001);
        assertEquals(0.25, kalkulatorBMI.calcBMI(1, 2), 0.00001);
        assertEquals(24.77661444023663, kalkulatorBMI.calcBMI(100.1, 2.01), 0.00001);
    }
}