package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalizaTekstuTest {


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

    @Test
    @DisplayName("Liczba słow")
    void liczbaSlowTest() {
        assertEquals(31, analizaTekstu.getLiczbaSlow());
    }

    @Test
    @DisplayName("Liczba zdań")
    void liczbaZdanTest() {
        assertEquals(5, analizaTekstu.getLiczbaZdan());
    }

    @Test
    @DisplayName("Średnia długość słowa")
    void sredniaDlugoscSlowaTest() {
        assertEquals(4.7, analizaTekstu.getSredniaDlugoscSlowa(), 0.01);
    }

    @Test
    @DisplayName("Liczba unikalnych słów")
    void liczbaUnikalnychSlowTest() {
        assertEquals(30, analizaTekstu.getLiczbaUnikalnychSlow());
    }

    @Test
    @DisplayName("Liczba znaków")
    void liczbaZnakowTest() {
        assertEquals(146, analizaTekstu.getLiczbaZnakow());
    }
}