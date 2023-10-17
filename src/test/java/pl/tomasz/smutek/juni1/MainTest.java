package pl.tomasz.smutek.juni1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

@DisplayName("Moja klasa testowa")
class MainTest {

    @BeforeAll// metoda oznaczona jako ta, która ma zostać wykonana raz przed wsyzstkimi metodami
    static void runAsAFirst(){
        System.out.println("-- Wykonana raz jako pierwsza");
    }

    @BeforeEach // metoda oznaczona jako ta, która ma być wykonana przed wsyztskimi metodami testowymi
    void setUp(){
        System.out.println("- Wykonuje się przed każdą metodą testową");
    }

    @Test // oznaczenie, że ta metoda jest metodą testową
    @DisplayName("Moja pierwsza metoda testowa") // daje mozlowść nazwania metod testowych niezależnie od nazwy metody
    void myFirstTestMethod(){
        System.out.println("To jest moja pierwsza metoda");
    }

    @Test
    @DisplayName("Moja druga metoda testowa")
    @Disabled // wyłacza tą metodę - nie bedzie puszczany dla niej test
    void mySecondTestMethod(){
        System.out.println("To jest moja druga metoda");
    }

    @Test
    @DisplayName("Przykłady typowych asercji")
    void demoTest(){

        // test assertEquals
        Assertions.assertEquals(1, 1, "Sprawdzam czy te liczby są takie same"); // sprawdza czy wartośc zwracana jest taka sama jak oczekiwana

        // TODO: napisz test assertNotEquals

        // test assertTrue
        Assertions.assertTrue(1==1); // sprawdz czy wyrazęnie zwróci wartość logiczną true

        // TODO: napisz test dla sprawdzenia czy wyrażenie zwraca wartość false

        // test assertNull
        Assertions.assertNull(null); // sprawdza czy wyrażenie zwraca null

        // TODO: napisz test dla sprawdzenia czy wyrażenie nie zwraca wartości null

        // zdefiniowanie asercji za pomoca lambdy
        IndexOutOfBoundsException exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            double[] tab = new double[2];
            tab[3] = 0.0;
        });
        System.out.println(exception);

        // zdefiniowanie asercji na podstawie klasy anonimowej wewnętrznej
        Assertions.assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                double[] tab = new double[2];
                tab[3] = 0.0;
            }
        });

    }

    // TODO: dopisz dwie kolejne metody testowe

    @AfterEach// metoda oznaczona jako ta, która ma być wykonana po każdej metododzie testowyej
    void cleanUp(){
        System.out.println("- Wykonuje się po kazej metodzie");
    }

    // TODO: dopiszcie metodę, która zostanie wykonaa raz po wszystkich metodach (@AfterAll)

}