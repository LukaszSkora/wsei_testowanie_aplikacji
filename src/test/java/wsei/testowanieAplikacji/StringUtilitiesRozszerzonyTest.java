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


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StringUtilitiesRozszerzonyTest {

    StringUtilities strUtils;

    @BeforeEach
    void setUp() {
        strUtils = new StringUtilities();
    }

    @TestFactory
    @DisplayName("Odwracanie (dynamiczny)")
    public Stream<DynamicTest> reverseDynamicznyTest() {
        String [][] strings = new String[][] {{"Ala ma kota", "atok am alA"}, {"", ""}, {"kajak", "kajak"}};

        Stream<String[]> stream = Arrays.stream(strings);

        return stream.map(strings1 -> {
            String tekst = strings1[0];
            String exp = strings1[1];

            return DynamicTest.dynamicTest("Odwracanie (dynamiczny)", () -> {
                assertEquals(exp, strUtils.reverse(tekst));
            });
        });
    }

    private static Stream<Arguments> daneDlaRemoveWhitespaceParametryzowanyTest() {
        return Stream.of(
                Arguments.of("Ala ma kota", "Alamakota"),
                Arguments.of("", ""),
                Arguments.of("kajak", "kajak")
        );
    }

    @ParameterizedTest(name = "Usuwanie białych znaków (parametryzowany): {0} -> {1}")
    @MethodSource(value = "daneDlaRemoveWhitespaceParametryzowanyTest")
    public void removeWhitespaceParametryzowanyTest(String text, String textOczekiwany) {
        assertEquals(textOczekiwany, strUtils.removeWhitespace(text));
    }

    @Test
    @DisplayName("Palindrom (assert all)")
    public void isPalindromeAssertAllTest() {
        Assertions.assertAll(
                () -> assertFalse(strUtils.isPalindrome("aJja")),
                () -> assertTrue(strUtils.isPalindrome("")),
                () -> assertTrue(strUtils.isPalindrome("kajak"))
        );
    }

    @Test
    @DisplayName("CamelCase (timeout)")
    public void camelCaseTimeoutTest() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (!osName.contains("linux")) {
            System.out.println("Ta metoda może być testowana tylko ns systemie Linux.");
            return;
        }
        Assertions.assertTimeout(Duration.ofMillis(10), () -> {
            strUtils.camelCase("");
        });
    }

    @ParameterizedTest(name = "Duże Litery (parametryzowany): {0} -> {1}")
    @CsvSource(
            delimiterString = "|",
            textBlock = """
                    AlaMaKota   | ALAMAKOTA
                    Ala ma kota | ALA MA KOTA
                    ""          | ""
                    Ala_ma_kota | ALA_MA_KOTA
                    """)
    public void upperParametryzowanyTest(String text, String textOczekiwany) {
        assertEquals(textOczekiwany, strUtils.upper(text));
    }
}