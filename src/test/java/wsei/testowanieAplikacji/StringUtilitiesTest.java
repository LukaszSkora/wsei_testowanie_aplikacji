package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilitiesTest {

    StringUtilities strUtils;

    @BeforeEach
    void setUp() {
        strUtils = new StringUtilities();
    }

    @Test
    @DisplayName("Odwracanie")
    void reverseTest() {
        assertEquals("Ala ma kota", strUtils.reverse("atok am alA"));
        assertEquals("", strUtils.reverse(""));
        assertEquals("kajak", strUtils.reverse("kajak"));
    }

    @Test
    @DisplayName("Usuwanie białych znaków")
    void removeWhitespaceTest() {
        assertEquals("Alamakota", strUtils.removeWhitespace("Ala ma kota"));
        assertEquals("", strUtils.removeWhitespace(""));
        assertEquals("kajak", strUtils.removeWhitespace(" kajak  "));
    }

    @Test
    @DisplayName("Palindrom")
    void isPalindromeTest() {
        assertFalse(strUtils.isPalindrome("aJja"));
        assertTrue(strUtils.isPalindrome(""));
        assertTrue(strUtils.isPalindrome("kajak"));
    }

    @Test
    @DisplayName("CamelCase")
    void camelCaseTest() {
        assertEquals("Alamakota", strUtils.camelCase("AlaMaKota"));
        assertEquals("AlaMaKota", strUtils.camelCase("Ala ma kota"));
        assertEquals("", strUtils.camelCase(""));
        assertEquals("AlaMaKota", strUtils.camelCase("Ala_ma_kota"));
    }

    @Test
    @DisplayName("Duże Litery")
    void upperTest() {
        assertEquals("ALAMAKOTA", strUtils.upper("AlaMaKota"));
        assertEquals("ALA MA KOTA", strUtils.upper("Ala ma kota"));
        assertEquals("", strUtils.upper(""));
        assertEquals("ALA_MA_KOTA", strUtils.upper("Ala_ma_kota"));
    }

    @Test
    @DisplayName("Usuń A/a")
    void removeATest() {
        assertEquals("lMKot", strUtils.removeA("AlaMaKota"));
        assertEquals("l m kot", strUtils.removeA("Ala ma kota"));
        assertEquals("", strUtils.removeA(""));
        assertEquals("l_m_kot", strUtils.removeA("Ala_ma_kota"));
    }
}