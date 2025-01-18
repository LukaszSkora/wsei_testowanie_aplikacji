package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeometriaTest {

    Geometria geometria;

    @BeforeEach
    void setUp() {
        geometria = new Geometria();
    }

    @Test
    @DisplayName("Pole prostokąta")
    void poleProstokataTest() {
        assertEquals(0, geometria.poleProstokata(0, 0), 0.00001);
        assertEquals(2, geometria.poleProstokata(1, 2), 0.00001);
        assertEquals(1.5, geometria.poleProstokata(0.5, 3), 0.00001);
    }

    @Test
    @DisplayName("Obwód prostokąta")
    void obwodProstokataTest() {
        assertEquals(0, geometria.obwodProstokata(0, 0), 0.00001);
        assertEquals(6, geometria.obwodProstokata(1, 2), 0.00001);
        assertEquals(3.22, geometria.obwodProstokata(0.5, 1.11), 0.00001);
    }

    @Test
    @DisplayName("Pole kwadratu")
    void poleKwadratuTest() {
        assertEquals(0, geometria.poleKwadratu(0), 0.00001);
        assertEquals(1, geometria.poleKwadratu(1), 0.00001);
        assertEquals(0.25, geometria.poleKwadratu(0.5), 0.00001);
    }

    @Test
    @DisplayName("Obwód kwadratu")
    void obwodKwadratuTest() {
        assertEquals(0, geometria.obwodKwadratu(0), 0.00001);
        assertEquals(4, geometria.obwodKwadratu(1), 0.00001);
        assertEquals(3.6, geometria.obwodKwadratu(0.9), 0.00001);
    }

    @Test
    @DisplayName("Pole trójkąta")
    void poleTrojkataTest() {
        assertEquals(0, geometria.poleTrojkata(0, 0), 0.00001);
        assertEquals(0, geometria.poleTrojkata(0, 1), 0.00001);
        assertEquals(3, geometria.poleTrojkata(2, 3), 0.00001);
    }

    @Test
    @DisplayName("Obwód trójkąta")
    void obwodTrojkataTest() {
        assertEquals(0, geometria.obwodTrojkata(0, 0 , 0), 0.00001);
        assertEquals(6, geometria.obwodTrojkata(1, 2, 3), 0.00001);
        assertEquals(0.111, geometria.obwodTrojkata(0.1, 0.01, 0.001), 0.00001);
    }

    @Test
    @DisplayName("Pole koła")
    void poleKolaTest() {
        assertEquals(0, geometria.poleKola(0), 0.00001);
        assertEquals(PI, geometria.poleKola(1), 0.00001);
        assertEquals(4 * PI, geometria.poleKola(2), 0.00001);
    }

    @Test
    @DisplayName("Obwód koła")
    void obwodKolaTest() {
        assertEquals(0, geometria.obwodKola(0), 0.00001);
        assertEquals(2 * PI, geometria.obwodKola(1), 0.00001);
        assertEquals(PI, geometria.obwodKola(0.5), 0.00001);
    }
}