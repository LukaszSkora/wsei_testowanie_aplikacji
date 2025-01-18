package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ListaZadanTest {

    ListaZadan listaZadan;

    @BeforeEach
    void setUp() {
        listaZadan = new ListaZadan();
    }

    @Test
    @DisplayName("Dodawanie zadania")
    void dodajZadanieTest() {
        listaZadan.dodajZadanie("moje zadanie 1");
        assertEquals(1, listaZadan.ileZadan());
        listaZadan.dodajZadanie("moje zadanie 2");
        assertEquals(2, listaZadan.ileZadan());
    }

    @Test
    @DisplayName("Usuwanie zadania")
    void usunZadanieTest() {
        listaZadan.dodajZadanie("moje zadanie 1");
        assertEquals(1, listaZadan.ileZadan());
        listaZadan.usunZadanie("moje zadanie 1");
        assertEquals(0, listaZadan.ileZadan());
    }

    @Test
    @DisplayName("Oznaczanie zadania jako wykonane")
    void oznaczJakoWykonaneTest() {
        listaZadan.dodajZadanie("moje zadanie 1");
        assertFalse(listaZadan.czyZadanieJestWykonane("moje zadanie 1"));
        listaZadan.oznaczZadanieJakoWykonane("moje zadanie 1");
        assertTrue(listaZadan.czyZadanieJestWykonane("moje zadanie 1"));
    }
}