package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GeometriaRozszerzonaTest {

    GeometriaRozszerzona geometria;

    @BeforeEach
    void setUp() {
        geometria = new GeometriaRozszerzona();
    }

    @TestFactory
    @DisplayName("Pole prostokąta (dynamiczny)")
    public Stream<DynamicTest> poleProstokataDynamicznyTest() {
        double [][] doubles = new double[][] {{0, 0, 0, 0.00001}, {1, 2, 2, 0.00001}, {2, 4.5, 9, 0.00001}};

        Stream<double[]> stream = Arrays.stream(doubles);

        return stream.map(doubles1 -> {
            double a = doubles1[0];
            double b = doubles1[1];
            double exp = doubles1[2];
            double delta = doubles1[3];

            return DynamicTest.dynamicTest("Pole prostokąta (dynamiczny)", () -> {
               Assertions.assertEquals(exp, geometria.poleProstokata(a, b), delta);
            });
        });
    }

    private static Stream<Arguments> daneDlaPoleTrojkataParametryzowanyTest() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0.00001),
                Arguments.of(1, 1, 0.5, 0.00001),
                Arguments.of(2, 8.5, 8.5, 0.00001)
        );
    }

    @ParameterizedTest(name = "Pole trójkąta (parametryzowany): a={0}, h={1}, pole={2}")
    @MethodSource(value = "daneDlaPoleTrojkataParametryzowanyTest")
    public void poleTrojkataParametryzowanyTest(double a, double h, double exp, double delta) {
        Assertions.assertEquals(exp, geometria.poleTrojkata(a, h), delta);
    }

    @Test
    @DisplayName("Obwód prostokąta (assert all)")
    public void obwodProstokataAssertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, geometria.obwodProstokata(0, 0), 0.00001),
                () -> Assertions.assertEquals(6, geometria.obwodProstokata(1, 2), 0.00001),
                () -> Assertions.assertEquals(5.5, geometria.obwodProstokata(0.5, 2.25), 0.00001)
        );
    }

    @Test
    @DisplayName("Obwód koła (timeout)")
    public void obwodKolaTimeoutTest() {
        Assertions.assertTimeout(Duration.ofMillis(10), () -> {
            geometria.obwodKola(4);
        });
    }

    @ParameterizedTest(name = "Pole kwadratu (parametryzowany): a={0}, pole={1}")
    @CsvSource(
            delimiterString = "|",
            textBlock = """
                    0    | 0    | 0.00001
                    1    | 1    | 0.00001
                    2.5  | 6.25 | 0.00001
                    """)
    public void poleKwadratuParametryzowanyTest(double a, double exp, double delta) {
        Assertions.assertEquals(exp, geometria.poleKwadratu(a), delta);
    }
}