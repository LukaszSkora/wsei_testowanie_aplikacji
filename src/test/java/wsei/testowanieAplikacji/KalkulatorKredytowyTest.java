package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorKredytowyTest {

    KalkulatorKredytowy kalkulatorKredytowy;

    @BeforeEach
    void setUp() {
        kalkulatorKredytowy = new KalkulatorKredytowy();
    }

    @Test
    @DisplayName("Kalkulator Kredytowy")
    void obliczRateTest() {
        assertEquals(10,
                kalkulatorKredytowy.obliczRate(
                        120,
                        0,
                        12,
                        12
                        ),
                0.001
        );
        assertEquals(5,
                kalkulatorKredytowy.obliczRate(
                        120,
                        0,
                        12,
                        24
                ),
                0.001
        );
        assertEquals(1043.861,
                kalkulatorKredytowy.obliczRate(
                        12000,
                        8,
                        12,
                        12
                ),
                0.001
        );
        assertEquals(376.036,
                kalkulatorKredytowy.obliczRate(
                        12000,
                        8,
                        12,
                        36
                ),
                0.001
        );
    }
}