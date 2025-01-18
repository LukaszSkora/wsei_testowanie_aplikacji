package wsei.testowanieAplikacji;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;


@TestMethodOrder(MethodOrderer.MethodName.class)
class KonwersjaJednostekRozszerzonaTest {

    KonwersjaJednostekRozszerzona konwersjaJednostek;

    @BeforeEach
    void setUp() {
        konwersjaJednostek = new KonwersjaJednostekRozszerzona();
    }

    @TestFactory
    @DisplayName("Kg na funty (dynamiczny)")
    public Stream<DynamicTest> kgFuntyDynamicznyTest() {
        double [][] doubles = new double[][] {{0, 0, 0.00001}, {1, 2.20462, 0.00001}, {10.1, 22.266662, 0.00001}};

        Stream<double[]> stream = Arrays.stream(doubles);

        return stream.map(doubles1 -> {
            double kg = doubles1[0];
            double exp = doubles1[1];
            double delta = doubles1[2];

            return DynamicTest.dynamicTest("Kg na funty (dynamiczny)", () -> {
                Assertions.assertEquals(exp, konwersjaJednostek.kgToPound(kg), delta);
            });
        });
    }

    private static Stream<Arguments> daneDlaMileKilometryParametryzowanyTest() {
        return Stream.of(
                Arguments.of(0, 0, 0.00001),
                Arguments.of(1, 1.609344, 0.00001),
                Arguments.of(10.1, 16.2543744, 0.00001)
        );
    }

    @ParameterizedTest(name = "Mile na kilometry (parametryzowany): mile={0}, km={1}")
    @MethodSource(value = "daneDlaMileKilometryParametryzowanyTest")
    public void mileKilometryParametryzowanyTest(double mile, double km, double delta) {
        Assertions.assertEquals(km, konwersjaJednostek.mileToKm(mile), delta);
    }

    @Test
    @DisplayName("Litry na galony (assert all)")
    public void litryGalonyAssertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, konwersjaJednostek.literToGallon(0), 0.00001),
                () -> Assertions.assertEquals(0.2641720524, konwersjaJednostek.literToGallon(1), 0.00001),
                () -> Assertions.assertEquals(2.66813772924, konwersjaJednostek.literToGallon(10.1), 0.00001)
        );
    }

    @Test
    @DisplayName("Litry na uncje imperialne (timeout)")
    public void litryUncjeImperialneTimeoutTest() {
        Assertions.assertTimeout(Duration.ofMillis(10), () -> {
            konwersjaJednostek.literToOunce(4);
        });
    }

    @ParameterizedTest(name = "Litry na pinty imperialne (parametryzowany): l={0}, pinty imperialne={1}")
    @CsvSource(
            delimiterString = "|",
            textBlock = """
                    0    | 0          | 0.00001
                    1    | 1.759754   | 0.00001
                    10.1 | 17.7735154 | 0.00001
                    """)
    public void litryPintyImperialneParametryzowanyTest(double litry, double pinty, double delta) {
        Assertions.assertEquals(pinty, konwersjaJednostek.literToPint(litry), delta);
    }
}
