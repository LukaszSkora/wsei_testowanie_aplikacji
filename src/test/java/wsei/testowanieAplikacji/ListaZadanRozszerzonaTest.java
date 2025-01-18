package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListaZadanRozszerzonaTest {

    ListaZadan listaZadan;

    @BeforeEach
    void setUp() {
        listaZadan = new ListaZadan();
    }

    @TestFactory
    @DisplayName("Dodawanie zadania (dynamiczny)")
    public Stream<DynamicTest> dodajZadanieDynamicznyTest() {
        String[][] strings = new String[][]{
                {"moje zadanie 1", "1"},
                {"moje zadanie 2", "2"},
                {"moje zadanie 3", "3"}
        };

        Stream<String[]> stream = Arrays.stream(strings);

        return stream.map(strings1 -> {
            String zadanie = strings1[0];
            String exp = strings1[1];

            return DynamicTest.dynamicTest("Dodawanie zadania (dynamiczny)", () -> {
                {
                    listaZadan.dodajZadanie(zadanie);
                    assertEquals(Integer.valueOf(exp), listaZadan.ileZadan());
                }
            });
        });
    }

    private static Stream<Arguments> daneDlaUsunZadanieParametryzowanyTest() {
        return Stream.of(
                Arguments.of("moje zadanie 1"),
                Arguments.of("moje zadanie 100"),
                Arguments.of("")
        );
    }

    @ParameterizedTest(name = "Usuwanie zadania (parametryzowany): {0}")
    @MethodSource(value = "daneDlaUsunZadanieParametryzowanyTest")
    public void usunZadanieParametryzowanyTest(String zadanie) {
        {
            listaZadan.dodajZadanie(zadanie);
            assertEquals(1, listaZadan.ileZadan());
            listaZadan.usunZadanie(zadanie);
            assertEquals(0, listaZadan.ileZadan());
        }
    }

    @ParameterizedTest(name = "Oznaczanie zadania jako wykonane (parametryzowany): {0}")
    @CsvSource(
            delimiterString = "|",
            textBlock = """
                    moje zadanie 1
                    moje zadanie 2
                    moje zadanie 3
                    """)
    public void oznaczZadanieJakoWykonaneParametryzowanyTest(String zadanie) {
        {
            listaZadan.dodajZadanie(zadanie);
            assertFalse(listaZadan.czyZadanieJestWykonane(zadanie));
            listaZadan.oznaczZadanieJakoWykonane(zadanie);
            assertTrue(listaZadan.czyZadanieJestWykonane(zadanie));
        }
    }

    @Test
    @DisplayName("Dodawanie zadania (assert all)")
    public void dodajZadanieAssertAllTest() {
        Assertions.assertAll(
                () -> {
                    listaZadan.dodajZadanie("moje zadanie 1");
                    assertEquals(1, listaZadan.ileZadan());
                    listaZadan.dodajZadanie("moje zadanie 2");
                    assertEquals(2, listaZadan.ileZadan());
                },
                () -> {
                    listaZadan.dodajZadanie("moje zadanie 100");
                    assertEquals(3, listaZadan.ileZadan());
                    listaZadan.dodajZadanie("");
                    assertEquals(4, listaZadan.ileZadan());
                },
                () -> {
                    listaZadan.dodajZadanie("moje zadanie 11111111111111111111111111111111111111");
                    assertEquals(5, listaZadan.ileZadan());
                    listaZadan.dodajZadanie("moje zadanie 2!@#$%^&*()_+");
                    assertEquals(6, listaZadan.ileZadan());
                }
        );
    }

    @Test
    @DisplayName("Dodawanie zadania (timeout)")
    public void dodajZadanieTimeoutTest() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (!osName.contains("linux")) {
            System.out.println("Ta metoda może być testowana tylko ns systemie Linux.");
            return;
        }
        Assertions.assertTimeout(Duration.ofMillis(10), () -> {
            listaZadan.dodajZadanie("moje zadanie 1");
        });
    }
}