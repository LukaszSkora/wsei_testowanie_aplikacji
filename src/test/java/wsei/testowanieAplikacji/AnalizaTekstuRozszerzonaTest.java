package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.MethodName.class)
class AnalizaTekstuRozszerzonaTest {


    String TEKST = """
                Litwo! Ojczyzno moja! ty jesteś jak zdrowie.
                Ile cię trzeba cenić, ten tylko się dowie,
                Kto cię stracił. Dziś piękność twą w całej ozdobie
                Widzę i opisuję, bo tęsknię po tobie.
                """;

    AnalizaTekstu analizaTekstu;

    @BeforeEach
    void setUp() {
        analizaTekstu = new AnalizaTekstu(TEKST);
    }

    @TestFactory
    @DisplayName("Liczba słow (dynamiczny)")
    public Stream<DynamicTest> kgFuntyDynamicznyTest() {
        int [][] ints = new int[][] {{31}};

        Stream<int[]> stream = Arrays.stream(ints);

        return stream.map(ints1 -> {
            double exp = ints1[0];

            return DynamicTest.dynamicTest("Liczba słow (dynamiczny)", () -> {
                Assertions.assertEquals(exp, analizaTekstu.getLiczbaSlow());
            });
        });
    }

    private static Stream<Arguments> daneDlaLiczbaZdanParametryzowanyTest() {
        return Stream.of(
                Arguments.of(5)
        );
    }

    @ParameterizedTest(name = "Liczba zdań (parametryzowany): {0}")
    @MethodSource(value = "daneDlaLiczbaZdanParametryzowanyTest")
    public void mileKilometryParametryzowanyTest(int liczbaZdan) {
        Assertions.assertEquals(liczbaZdan, analizaTekstu.getLiczbaZdan());
    }

    @Test
    @DisplayName("Średnia długość słowa (assert all)")
    public void litryGalonyAssertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(4.7, analizaTekstu.getSredniaDlugoscSlowa(), 0.01)
        );
    }

    @Test
    @DisplayName("Liczba unikalnych słów (timeout)")
    public void liczbaUnikalnychSlowTimeoutTest() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (!osName.contains("linux")) {
            System.out.println("Ta metoda może być testowana tylko ns systemie Linux.");
            return;
        }
        Assertions.assertTimeout(Duration.ofMillis(10), () -> {
            analizaTekstu.getLiczbaUnikalnychSlow();
        });
    }

    @ParameterizedTest(name = "Liczba znaków (parametryzowany): {0}")
    @CsvSource(
            delimiterString = "|",
            textBlock = """
                    146
                    """)
    public void litryPintyImperialneParametryzowanyTest(int liczbaZnakow) {
        Assertions.assertEquals(liczbaZnakow, analizaTekstu.getLiczbaZnakow());
    }
}