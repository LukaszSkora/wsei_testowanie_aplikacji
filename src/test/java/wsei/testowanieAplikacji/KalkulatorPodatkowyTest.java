package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KalkulatorPodatkowyTest {

    KalkulatorPodatkowy kalkulatorPodatkowy;

    @BeforeEach
    void setUp() {
        kalkulatorPodatkowy = new KalkulatorPodatkowy();
    }

    @Test
    @DisplayName("Ryczałt - 0")
    void ryczaltZeroTest() {
        assertEquals(0,
                kalkulatorPodatkowy.obliczPodatekDochodowy(
                        20000,
                        10000,
                        "ryczałt"
                ),
                0.001
        );
    }

    @Test
    @DisplayName("Ryczałt - A")
    void ryczaltATest() {
        assertEquals(3288,
                kalkulatorPodatkowy.obliczPodatekDochodowy(
                        100000,
                        10000,
                        "ryczałt"
                ),
                0.001
        );
    }

    @Test
    @DisplayName("Liniowy")
    void liniowyTest() {
        assertEquals(9000,
                kalkulatorPodatkowy.obliczPodatekDochodowy(
                        100000,
                        10000,
                        "liniowy"
                ),
                0.001
        );
    }

    @Test
    @DisplayName("Skala12")
    void skala12Test() {
        assertEquals(2700,
                kalkulatorPodatkowy.obliczPodatekDochodowy(
                        100000,
                        10000,
                        "skala"
                ),
                0.001
        );
    }

    @Test
    @DisplayName("Skala32")
    void skala32Test() {
        assertEquals(43700,
                kalkulatorPodatkowy.obliczPodatekDochodowy(
                        200000,
                        10000,
                        "skala"
                ),
                0.001
        );
    }
}